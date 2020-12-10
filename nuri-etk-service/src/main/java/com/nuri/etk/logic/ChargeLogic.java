package com.nuri.etk.logic;

import com.nuri.etk.async.constants.ETKConstants;
import com.nuri.etk.async.constants.StsConstants;
import com.nuri.etk.async.data.CmdSendToken;
import com.nuri.etk.async.queue.AsyncQueueHandler;
import com.nuri.etk.entity.API.Charge;
import com.nuri.etk.entity.aimir.*;
import com.nuri.etk.entity.pojo.ArrearsDebt;
import com.nuri.etk.entity.pojo.ChargeCancelInfo;
import com.nuri.etk.entity.pojo.ChargeInfo;
import com.nuri.etk.prod.etkEventBinder;
import com.nuri.etk.spec.ChargeService;
import com.nuri.etk.store.ChargeStore;
import com.nuri.etk.store.CodeStore;
import com.nuri.etk.util.*;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

@Service
@Transactional
public class ChargeLogic implements ChargeService {
    protected static Log log = LogFactory.getLog(ChargeLogic.class);

    @Autowired
    AsyncQueueHandler asyncQueueHandler;

    private final ChargeStore chargeStore;
    private final CodeStore codeStore;
    private final etkEventBinder binder;


    public ChargeLogic(ChargeStore chargeStore, CodeStore codeStore, etkEventBinder binder) {
        this.chargeStore = chargeStore;
        this.codeStore = codeStore;
        this.binder = binder;
    }

    @Override
    public Charge meterCharge(String meterId, HttpHeaders headers, ChargeInfo chargeInfo) throws Exception {
        Charge charge = new Charge();
        String result = null;
        String token = null;

        JSONObject response = balanceCharge(meterId, headers, chargeInfo);
        result = (String) response.get("result");

        if (result.equals("success")) {
            token = (String) response.get("token");
            charge.setToken(token);
            charge.setCode(200);
        }else if(result.equals("failed")){
            charge.setCode(361);
        }
        charge.setResultDetail(result);

        return charge;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Charge meterChargeCancle(String meterId, HttpHeaders headers, ChargeCancelInfo chargeCancelInfo) throws Exception {
        Charge charge = new Charge();
        String result = null;
        String token = null;

        JSONObject response = balanceChargeCancle(meterId, headers, chargeCancelInfo);
        result = (String) response.get("result");

        if(result.equals("success")){
            token = (String) response.get("token");
            charge.setToken(token);
            charge.setCode(200);
        }else if(result.equals("canceled Data")){
            charge.setCode(560);
        }else if(result.equals("failed")){
            charge.setCode(361);
        }
        charge.setResultDetail(result);

        return charge;
    }

    public JSONObject balanceCharge(String meterId, HttpHeaders headers, ChargeInfo chargeInfo) throws JSONException {
        JSONObject responseCode = new JSONObject();
        Map<String, Object> conditionMap = new HashMap<String, Object>();
        String supplierName = null;
        String uuid = null;
        String operatorId = null;
        String chargeId = null;
        Double paidAmount = 0d;
        Double debtAmount = 0d;
        Double arrearsAmount = 0d;
        Double chargedCredit = 0d;
        List<ArrearsDebt> debtList = null;
        int timeout = 0;
        String callBackURI = null;

        try {
            operatorId = chargeInfo.getOperatorId();
            chargeId = chargeInfo.getChargeId();
            paidAmount = Double.parseDouble(chargeInfo.getPaidAmount());
            chargedCredit = Double.parseDouble(chargeInfo.getChargedCredit());
            arrearsAmount = Double.parseDouble(chargeInfo.getChargedArrears());
            debtList = (List<ArrearsDebt>) chargeInfo.getDebt();
            timeout =  Integer.parseInt(headers.get("timeout").get(0).toString());
            callBackURI = headers.get("callbackUrl").get(0).toString();
        } catch (Exception e) {
            APICallBackHistory history = new APICallBackHistory();
            history.setMdevId(meterId);
            history.setOperatorId(operatorId);
            history.setTid(chargeId);
            history.setCallBackURI(callBackURI);
            history.setColumn01(String.valueOf(paidAmount)); //충전일 경우 column01 항목에 내용을 저장한다.
            history.setDescr("Exception : " + e.getMessage());
            updateCallbackHistory(uuid, history);

            responseCode.put("code", ETKConstants.ErrorType.missingRequiredData.getIntValue());
            responseCode.put("msgUser", ETKConstants.ErrorType.missingRequiredData);
            responseCode.put("msgDeveloper", e.getMessage());
            responseCode.put("result", "failed");
            return responseCode;
        }

        try {
            chargedCredit = paidAmount;
            conditionMap.put("chargedCredit", chargedCredit);
            conditionMap.put("mdsId", meterId);
            conditionMap.put("operatorId", operatorId);
            conditionMap.put("chargeId", chargeId);
            conditionMap.put("paidAmount", paidAmount); // 지불한 금액

            if (0 < debtList.size()) {
//                List<Map<String, Object>> debtList = new ArrayList<Map<String, Object>>();
                for (int i = 1; i < debtList.size(); i++) {
                    debtAmount += debtList.get(i).getPaidDebtAmount();
                }

                conditionMap.put("debtAmount", debtAmount); // 충전하려는 debt amount
                conditionMap.put("arrearsAmount", arrearsAmount); // 충전하려는 arrears amount
                conditionMap.put("debtList", debtList); // 충전하려는 debt list

                chargedCredit = paidAmount - (debtAmount + arrearsAmount);
                conditionMap.put("chargedCredit", chargedCredit); // 실제로 충전되는 금액
            }

            log.info("paidAmount: " + paidAmount + ", debtAmount: " + debtAmount + ", arrearsAmount: " + arrearsAmount + ", chargedCredit" + chargedCredit);
            responseCode = balanceChargeImpl(conditionMap);
        } catch (Exception e) {
            log.error(e,e);
            APICallBackHistory history = new APICallBackHistory();
            history.setMdevId(meterId);
            history.setOperatorId(operatorId);
            history.setTid(chargeId);
            history.setCallBackURI(callBackURI);
            history.setColumn01(String.valueOf(paidAmount)); //충전일 경우 column01 항목에 내용을 저장한다.
            history.setDescr("Exception : " + e.getMessage());
            updateCallbackHistory(uuid, history);

            responseCode.put("code", ETKConstants.ErrorType.internalServerError.getIntValue());
            responseCode.put("msgUser", ETKConstants.ErrorType.internalServerError);
            responseCode.put("msgDeveloper", e.getMessage());
            responseCode.put("result", "failed");
            return responseCode;
        }

        if (!ETKConstants.ErrorType.Ok.getValue().equals(Integer.parseInt(responseCode.get("code").toString()))) {
            return responseCode;

        }

        // token 전송 (S)
        try {
            String token = responseCode.get("token").toString();
            String mdsId = responseCode.get("meterId").toString();
            log.info("## Token Retry: meter number[" + mdsId + "] token[" + token + "]");

            if (sendSTSToken(uuid, mdsId, token, chargeId, timeout, callBackURI) == "success") {
                responseCode.put("ResultDetail", "token gen:" + true + ", set:" + true);
                responseCode.put("result", "success");
            }

            APICallBackHistory history = new APICallBackHistory();
            history.setMdevId(meterId);
            history.setOperatorId(operatorId);
            history.setTid(chargeId);
            history.setCallBackURI(callBackURI);
            history.setColumn01(String.valueOf(paidAmount)); //충전일 경우 column01 항목에 내용을 저장한다.
            if(responseCode != null && !responseCode.isNull("prepaymentId")) {
                history.setPrepaymentLogId(Long.parseLong(responseCode.get("prepaymentId").toString()));
            }

            updateCallbackHistory(uuid, history);
        } catch (Exception e) {
            APICallBackHistory history = new APICallBackHistory();
            history.setMdevId(meterId);
            history.setOperatorId(operatorId);
            history.setTid(chargeId);
            history.setCallBackURI(callBackURI);
            history.setColumn01(String.valueOf(paidAmount)); //충전일 경우 column01 항목에 내용을 저장한다.
            history.setDescr("Exception : " + e.getMessage());
            updateCallbackHistory(uuid, history);

            responseCode.put("code", ETKConstants.ErrorType.failToSendSTSToken.getIntValue());
            responseCode.put("msgUser", ETKConstants.ErrorType.failToSendSTSToken);
            responseCode.put("msgDeveloper", e.getMessage());
            responseCode.put("result", "failed");
            return responseCode;
        }
        // token 전송 (E)

        return responseCode;
    }

    public JSONObject balanceChargeImpl(Map<String, Object> condition) throws JSONException {
        JSONObject responseCode = new JSONObject();
        String mdsId = StringUtil.nullToBlank(condition.get("mdsId"));
        String operatorId = condition.get("operatorId").toString();
        Double paidAmount = Double.parseDouble(condition.get("paidAmount").toString());
        Double chargedCredit = Double.parseDouble(condition.get("chargedCredit").toString());
        Double arrearsAmount = Double.parseDouble(condition.get("arrearsAmount").toString());
        Double debtAmount = Double.parseDouble(condition.get("debtAmount").toString());
        String chargeId = StringUtil.nullToBlank(condition.get("chargeId"));
        List<ArrearsDebt> currentDebtList = (List<ArrearsDebt>) condition.get("debtList");

        try {
            Meter meter = chargeStore.getMeter(mdsId);
            Modem md = meter.getModem();
            String modemDeviceSerial = md.getDeviceSerial();
            String meterModelName = meter.getModel().getName();

            Contract contract = null;
            contract = meter.getContract();
            if (contract == null) {
                responseCode.put("code", ETKConstants.ErrorType.contractDoesNotExist.getIntValue());
                responseCode.put("msgUser", ETKConstants.ErrorType.contractDoesNotExist);
                responseCode.put("msgDeveloper", ETKConstants.ErrorType.contractDoesNotExist);
                return responseCode;
            }

            Customer customer = null;
            customer = contract.getCustomer();
            String customerNo = StringUtil.nullToBlank(contract.getCustomerId());
            if (customerNo == null) {
                responseCode.put("code", ETKConstants.ErrorType.customerDoesNotExist.getIntValue());
                responseCode.put("msgUser", ETKConstants.ErrorType.customerDoesNotExist);
                responseCode.put("msgDeveloper", ETKConstants.ErrorType.contractDoesNotExist);
                return responseCode;
            }

            List<DebtEnt> debtEntList = chargeStore.getDebtEnt(customerNo, null, null);

            /*Operator updateOperator = chargeStore.getOperator(operatorId);
            if (updateOperator == null) {
                responseCode.put("code", ETKConstants.ErrorType.operatorDoesNotExist.getIntValue());
                responseCode.put("msgUser", ETKConstants.ErrorType.operatorDoesNotExist);
                responseCode.put("msgDeveloper", ETKConstants.ErrorType.operatorDoesNotExist);
                return responseCode;
            }*/

            // 납기일이 지난 Debt Check (S)
            int currentDate = Integer.parseInt(TimeUtil.getCurrentDay());
            Double totalPastDebtAmount = 0d;

            for (int j = 0; j < debtEntList.size(); j++) {
                DebtEnt tempDebtEnt = debtEntList.get(j);

                // OPF-1747
                int installmentDueDate = 0;
                try {
                    installmentDueDate = Integer.parseInt(tempDebtEnt.getInstallmentDueDate());
                } catch (Exception e) {
                    responseCode.put("code", ETKConstants.ErrorType.missingRequiredData.getIntValue());
                    responseCode.put("msgUser", ETKConstants.ErrorType.missingRequiredData);
                    responseCode.put("msgDeveloper", "<WS_CMS_DEBTENT> installment_due_date can't be null!");
                    return responseCode;
                }

                Double debt = tempDebtEnt.getDebtAmount();

                if (currentDate > installmentDueDate) { // 납기일이 지난 경우
                    totalPastDebtAmount += debt;
                }
            }

            // debt을 충전하려는 금액보다 납부기일이 지난 미수금(debt)이 더 클 경우
            if (totalPastDebtAmount > debtAmount) {
                log.error("totalPastDebtAmount: " + totalPastDebtAmount + ", enteredDebtAmount: " + debtAmount);
                responseCode.put("code", ETKConstants.ErrorType.insufficientChargeAmount.getIntValue());
                responseCode.put("msgUser", ETKConstants.ErrorType.insufficientChargeAmount);
                responseCode.put("msgDeveloper", "This customer must first pay all amounts that have passed the due date."
                        + " totalPastDebtAmount: " + totalPastDebtAmount + ", enteredDebtAmount: " + debtAmount);
                return responseCode;
            }
            // 납기일이 지난 Debt Check (E)

            String token = null;
            String tokenDate = null;

            // OPF-1747
            if (meter.getModel() == null) {
                responseCode.put("code", ETKConstants.ErrorType.missingRequiredData.getIntValue());
                responseCode.put("msgUser", ETKConstants.ErrorType.missingRequiredData);
                responseCode.put("msgDeveloper", "<METER> deviceModel_id can't be null!");
                return responseCode;
            }

            if (meter != null) {
                if (contract.getTariffIndexId() == null) {
                    // Tariff가 설정되어있지 않으면 토큰 발급하지 않는다.
                    responseCode.put("code", ETKConstants.ErrorType.noTariffInformation.getIntValue());
                    responseCode.put("msgUser", ETKConstants.ErrorType.noTariffInformation);
                    responseCode.put("msgDeveloper", "No tariff information with this contract.");
                    return responseCode;
                }

                // 공통으로 사용
                String modelName = meter.getModel().getName();
                String vendorName = meter.getModel().getDeviceVendor().getName();

                /*
                 * Electricity : 0 Water : 1 Gas : 2 Time : 3 Credit(EM) : 4
                 * Credit(WM) : 5 Credit(GM) : 6 Credit(TIME) : 7
                 */
                // Credit 기준으로 작성
                String meterTypeCode = meter.getMeterType();
                String subClass = "4"; // default 4
                if ("1.3.1.1".equals(meterTypeCode)) {
                    subClass = "4";
                } else if ("1.3.1.2".equals(meterTypeCode)) {
                    subClass = "5";
                }

                // value format : A decimal integer greater than 0.
                // base currency units : 0.01, R50.01 금액 충전시 value는 5001로 넣어야한다.
                Double currencyUnits = 0.01;
                Double chargedFormatCredit = Double.parseDouble(String.format("%.2f", chargedCredit));
                Double value = null;
                value = chargedFormatCredit / currencyUnits;
                String tokenValue = String.valueOf(Math.round(value));

                if (vendorName != null && modelName != null) {
                    Properties prop = new Properties();
                    prop.load(getClass().getClassLoader().getResourceAsStream("command.properties"));
                    String stsBaseUrl = prop.getProperty("sts.baseUrl");
                    String SGC = prop.getProperty("sts.sgcNumber") == null ? "" : prop.getProperty("sts.sgcNumber");
                    String ipAddr = prop.getProperty("GG.sms.ipAddr") == null ? "" : prop.getProperty("GG.sms.ipAddr").trim();
                    String port = prop.getProperty("GG.sms.port") == null ? "" : prop.getProperty("GG.sms.port").trim();
                    String smsClassPath = prop.getProperty("smsClassPath");

                    String DSN = null;
                    String TCT = "02";
                    String EA = "07";
                    tokenDate = DateTimeUtil.getDateString(new Date());
                    String DOE = STSToken.getDOE(tokenDate);
                    String MfrCode = "24"; // WASION
                    String TI = "01";
                    String KRN = "1";

                    // OPF-1747
                    if (meter.getIhdId() == null) {
                        log.error("### Meter No: " + mdsId + ", STS Number Doesn't Exist!!");
                        responseCode.put("code", ETKConstants.ErrorType.stsNumberDoesNotExist.getIntValue());
                        responseCode.put("msgUser", ETKConstants.ErrorType.stsNumberDoesNotExist);
                        responseCode.put("msgDeveloper", ETKConstants.ErrorType.stsNumberDoesNotExist);
                        return responseCode;
                    }

                    if ((meter.getIhdId().length() == 8 || meter.getIhdId().length() == 11)) {
                        DSN = meter.getIhdId();
                    } else {
                        responseCode.put("code", ETKConstants.ErrorType.stsNumberDoesNotExist.getIntValue());
                        responseCode.put("msgUser", ETKConstants.ErrorType.stsNumberDoesNotExist);
                        responseCode.put("msgDeveloper", "Wrong STS Number!");
                        return responseCode;
                    }

                    String idRecord = STSToken.getIdRecord(TCT, EA, SGC, KRN, DSN, DOE, MfrCode, TI);

                    // subclass=1이 clearCredit.
                    if (stsBaseUrl != null && !"".equals(stsBaseUrl)) {
                        String sendURL = stsBaseUrl.trim() + "VendCredit.ini?";
                        sendURL += "meterId=" + idRecord + "&subclass=" + subClass + "&value=" + tokenValue;
                        token = STSToken.makeToken(sendURL);
                    }

                    // token : 20 digit
                    if (token == null || token.length() != 20 || token.contains("Exception")) {
                        responseCode.put("code", ETKConstants.ErrorType.failToGenerateSTSToken.getIntValue());
                        responseCode.put("msgUser", ETKConstants.ErrorType.failToGenerateSTSToken);
                        responseCode.put("msgDeveloper", ETKConstants.ErrorType.failToGenerateSTSToken);
                        return responseCode;

                    } else {
                        List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();
                        Map<String, String> paramMap = new HashMap<String, String>();
                        paramMap.put("string", token);
                        paramList.add(paramMap);

                        String cmd = "cmdSetTariff"; // OPF-1747
                        long trId = System.currentTimeMillis();

                        String createDate = DateTimeUtil.getDateString(new Date());
                        if (contract != null) {
//                            createStsCmdLog(contract.getContractNumber(), cmd, createDate, tokenDate, token, 100, trId, DateTimeUtil.getDateString(new Date()));
                        }
                    }

                }
            }

            String lastChargeDate = StringUtil.nullToBlank(contract.getLastTokenDate());
            Double preCredit = StringUtil.nullToDoubleZero(contract.getCurrentCredit());
            Double currentCredit = new BigDecimal(StringUtil.nullToZero(contract.getCurrentCredit())).add(new BigDecimal(StringUtil.nullToZero(chargedCredit))).doubleValue();
            Integer lastChargeCnt = new Integer(StringUtil.nullToZero(contract.getLastChargeCnt())) + 1;
//            Operator operator = operatorDao.getOperatorByLoginId(operatorId);
            Operator operator = chargeStore.getOperator(operatorId);

            // insert ContractChangeLog
            addContractChangeLog(contract, operator, "lastTokenDate", contract.getLastTokenDate(), DateTimeUtil.getCurrentDateTimeByFormat("yyyyMMddHHmmss"), null);
            addContractChangeLog(contract, operator, "chargedCredit", contract.getChargedCredit(), paidAmount, null);
            addContractChangeLog(contract, operator, "currentCredit", contract.getCurrentCredit(), currentCredit.toString(), null);
            addContractChangeLog(contract, operator, "lastChargeCnt", contract.getLastChargeCnt(), lastChargeCnt.toString(), null);

            contract.setContractPrice(null);
            contract.setLastTokenDate(DateTimeUtil.getCurrentDateTimeByFormat("yyyyMMddHHmmss"));
            contract.setChargedCredit(paidAmount);
            contract.setCurrentCredit(currentCredit); //수정필요
            contract.setLastChargeCnt(lastChargeCnt);
//            contract.setCashPoint(operator.getCashPoint());

            PrepaymentLog prepaymentLog = new PrepaymentLog();
            List<DebtLog> debtLogList = new ArrayList<DebtLog>();

            Double preArrears = contract.getCurrentArrears();
            prepaymentLog.setArrears(preArrears);
            prepaymentLog.setPreArrears(preArrears);
            prepaymentLog.setChargedArrears(0d);

            for (int i = 0; i < currentDebtList.size(); i++) {
                Map<String, Object> map = new HashMap<>();
                ArrearsDebt debts = currentDebtList.get(i);
                map.put("debtType", debts.getDebtType());
                map.put("debtRef", debts.getDebtRef());
                map.put("paidDebtAmount", debts.getPaidDebtAmount());

                Double payAmount = map.get("payAmount") != null ? Double.parseDouble(map.get("payAmount").toString()): 0.0;
                if (((String) map.get("debtType")).equals("Arrears")) {
                    Double currentArrears = new BigDecimal(StringUtil.nullToDoubleZero(preArrears)).subtract(new BigDecimal(payAmount)).doubleValue();
                    contract.setCurrentArrears(currentArrears);
                    prepaymentLog.setArrears(currentArrears);
                    prepaymentLog.setChargedArrears(payAmount);

                    addContractChangeLog(contract, operator, "currentArrears", preArrears, currentArrears, null);
                } else {
                    Double tempCurrentDebt = 0.0;
                    for (int j = 0; j < debtEntList.size(); j++) {
                        DebtEnt tempDebtEnt = debtEntList.get(j);

                        if (tempDebtEnt.getDebtRef().equals(map.get("debtRef").toString())) {
                            DebtLog debtLog = new DebtLog();
                            Double preDebt = tempDebtEnt.getDebtAmount();
                            tempCurrentDebt = new BigDecimal(StringUtil.nullToDoubleZero(preDebt)).subtract(new BigDecimal(payAmount)).doubleValue();
                            debtLog.setPreDebt(preDebt);
                            debtLog.setDebt(tempCurrentDebt);
                            debtLog.setChargedDebt(payAmount);
                            debtLog.setDebtRef(map.get("debtRef").toString());
                            debtLog.setCustomerId(customerNo);
                            debtLog.setDebtType(tempDebtEnt.getDebtType());

                            debtLogList.add(debtLog);
                            tempDebtEnt.setDebtAmount(tempCurrentDebt);
                            addContractChangeLog(contract, operator, "currentDebt", preDebt, tempCurrentDebt, tempDebtEnt.getDebtType());
                            debtEntList.set(j, tempDebtEnt);
                        }
                    }
                }
            }

            if (debtLogList.size() < debtEntList.size()) {
                List<DebtLog> tempLogList = new ArrayList<DebtLog>();
                for (int j = 0; j < debtLogList.size(); j++) {
                    tempLogList.add(debtLogList.get(j));
                }

                for (int i = 0; i < debtEntList.size(); i++) {
                    boolean flag = false;
                    DebtEnt debtEnt = debtEntList.get(i);
                    for (int j = 0; j < tempLogList.size(); j++) {
                        DebtLog debtLog = tempLogList.get(j);
                        if (!debtLog.getDebtRef().equals(debtEnt.getDebtRef())) {
                            flag = true;
                        } else {
                            flag = false;
                            break;
                        }
                    }

                    if (tempLogList.size() == 0) {
                        flag = true;
                    }

                    if (flag) {
                        DebtLog emptyDebtLog = new DebtLog();
                        emptyDebtLog.setPreDebt(debtEnt.getDebtAmount());
                        emptyDebtLog.setDebt(debtEnt.getDebtAmount());
                        emptyDebtLog.setChargedDebt(0d);
                        emptyDebtLog.setDebtRef(debtEnt.getDebtRef());
                        emptyDebtLog.setCustomerId(customerNo);
                        emptyDebtLog.setDebtType(debtEnt.getDebtType());
                        if (debtEnt.getDebtContractCount() != null && debtEnt.getDebtContractCount() > 0) {
                            emptyDebtLog.setPartpayInfo(StringUtil.nullToZero(debtEnt.getDebtPaymentCount()) + "/"
                                    + debtEnt.getDebtPaymentCount());
                        }
                        debtLogList.add(emptyDebtLog);
                    }
                }
            }

            // 미터가 교체되고 처음 결제 되는 경우 로그에 미터 교체 비용관련 항목이 추가된다.
            Integer daysFromCharge;
            if (lastChargeDate != null && !lastChargeDate.equals("")) {
                daysFromCharge = TimeUtil.getDayDuration(lastChargeDate,
                        DateTimeUtil.getCurrentDateTimeByFormat("yyyyMMddHHmmss"));
            } else {
                daysFromCharge = 0;
            }

//            VendorCasher vendorCasher = vendorCasherDao.getByVendorCasherId(operator.getLoginId(), operator);
            Code keyType = codeStore.getkeyType("18.7"); //nuri trade center

            if (token != null && !"".equals(token)) {
                prepaymentLog.setToken(token);
            }

            prepaymentLog.setLastTokenId(chargeId);
            prepaymentLog.setDaysFromCharge(daysFromCharge);
            prepaymentLog.setCustomerId(Integer.valueOf(contract.getCustomerId()));
            prepaymentLog.setContractId(contract.getId());
            prepaymentLog.setKeyType(null);
            prepaymentLog.setChargedCredit(chargedCredit);
            prepaymentLog.setLastTokenDate(DateTimeUtil.getCurrentDateTimeByFormat("yyyyMMddHHmmss"));
//            prepaymentLog.setOperator(operator);
            Integer emergencyYn = null;
            if (contract.getEmergencyCreditAvailable() != null) {
                emergencyYn = (contract.getEmergencyCreditAvailable()) ? 1 : 0;
            }
            prepaymentLog.setEmergencyCreditAvailable(emergencyYn);
//            prepaymentLog.setPowerLimit(contractDemand);
            prepaymentLog.setPreBalance(preCredit);
            prepaymentLog.setBalance(currentCredit);
            prepaymentLog.setLocation(contract.getLocation());
            prepaymentLog.setTariffIndexId(contract.getTariffIndexId());
            prepaymentLog.setPayType(keyType);

            // Prepaymentlog의 ID 생성방법 변경(id+시스템시간)
            prepaymentLog.setId(Long.parseLong(Integer.toString(contract.getId()) + Long.toString(System.currentTimeMillis())));
            chargeStore.addPrepaymentLog(prepaymentLog);

            log.info("prepaymentLog has been added");

            //TO Do DepositHistory insert
            DepositHistory dh = new DepositHistory();
//            dh.setOperator(updateOperator);
            dh.setContractId(contract.getId());
            dh.setCustomerId(Integer.valueOf(contract.getCustomerId()));
            dh.setMeterId(meter.getId());
            dh.setChangeDate(DateTimeUtil.getCurrentDateTimeByFormat("yyyyMMddHHmmss"));
            dh.setChargeCredit(paidAmount);
//            dh.setDeposit(updateOperator.getDeposit());
            dh.setPrepaymentLogId(prepaymentLog.getId());

            chargeStore.addDepositHistory(dh);

            for (int i = 0; i < debtLogList.size(); i++) {
                DebtLog debtLog = (DebtLog) debtLogList.get(i);
                debtLog.setPrepaymentLogId(prepaymentLog.getId());
                chargeStore.addDebtLog(debtLog);
            }

//            operatorDao.update(updateOperator);
//            log.info("operator update is completed");

            for (int i = 0; i < debtEntList.size(); i++) {
                ;
                chargeStore.updateDebtEnt((DebtEnt) debtEntList.get(i));
            }

            // update Contract
            chargeStore.updateContract(contract);

            log.info("contractInfo has been updated");
            log.info("depositHistory has been added");

            // result map (S)
            responseCode.put("code", ETKConstants.ErrorType.Ok.getIntValue());
            responseCode.put("resultDetail", "token gen:" + true + ", set:" + false);
            responseCode.put("token", token);
            responseCode.put("tokenDate", tokenDate);
            responseCode.put("receiptNo", prepaymentLog.getId().toString());
            responseCode.put("date", prepaymentLog.getLastTokenDate());
            responseCode.put("customer", contract.getCustomerName() != null ? contract.getCustomerName() : "");
            responseCode.put("geocode", contract.getContractNumber() != null ? contract.getContractNumber() : "");
            responseCode.put("accountNo", customerNo != null ? customerNo : "");
            responseCode.put("meterId", mdsId);
            responseCode.put("activity", contract.getTariffIndex() != null ? contract.getTariffIndex().getName() : "");
            responseCode.put("district", contract.getLocation() != null ? contract.getLocation().getName() : "");
            responseCode.put("address", StringUtil.nullToString(contract.getAddress1(), ""));
//            responseCode.put("payment", StringUtil.nullToString(keyType.getName(), ""));
            responseCode.put("daysFromLastCharge", StringUtil.nullToString(daysFromCharge, ""));
            responseCode.put("paidAmount", paidAmount != null ? paidAmount : 0d);
            responseCode.put("chargedArrears", arrearsAmount != null ? arrearsAmount : 0d);
            responseCode.put("chargedDebt", debtAmount != null ? debtAmount : 0d);
            responseCode.put("chargedAmount", chargedCredit != null ? chargedCredit : 0d);
            responseCode.put("beforeBalance", preCredit != null ? preCredit : 0d);
            responseCode.put("currentBalance", currentCredit != null ? currentCredit : 0d);

            log.info("transaction commit complated");

            String dvSerial = "-";
            if (md != null) {
                dvSerial = StringUtil.nullToString(modemDeviceSerial, "-");
            }
            responseCode.put("modemId", dvSerial);

            String mtModel = StringUtil.nullToString(meterModelName, "-");
            responseCode.put("meterModel", mtModel);

            responseCode.put("prepaymentId", prepaymentLog.getId());

            // result map (E)
        } catch (Exception e) {
            log.error(e,e);

            responseCode.put("code", ETKConstants.ErrorType.internalServerError.getIntValue());
            responseCode.put("msgUser", ETKConstants.ErrorType.internalServerError);
            responseCode.put("msgDeveloper", e);
            return responseCode;
        }

        log.info("method finished");
        return responseCode;
    }

    public JSONObject balanceChargeCancle(String meterId, HttpHeaders headers, ChargeCancelInfo chargeCancelInfo) throws JSONException {
        JSONObject returnData = new JSONObject();
//        Map<String, Object> returnData = new HashMap<String, Object>();
        String rtn = "success";
        String uuid = null;
        Contract contract = null;
        Double paidAmount = 0d;
        Double totalAmount = 0d;
        Properties prop = new Properties();
        String modelName = null;
        String vendorName = null;
        String id = chargeCancelInfo.getChargeId();
        String operatorId = chargeCancelInfo.getOperatorId();
        String reason = chargeCancelInfo.getCancelReason();
        String chargeId = chargeCancelInfo.getChargeId();
        int timeout =  Integer.parseInt(headers.get("timeout").get(0).toString());
        String callBackURI = headers.get("callbackUrl").get(0).toString();

        try {
            prop.load(getClass().getClassLoader().getResourceAsStream("command.properties"));
            String stsBaseUrl = prop.getProperty("sts.baseUrl");
            String SGC = prop.getProperty("sts.sgcNumber") == null ? "" : prop.getProperty("sts.sgcNumber");
            String isPartpaymentStr = prop.getProperty("partpayment.use");
            String ipAddr = prop.getProperty("GG.sms.ipAddr") == null ? "" : prop.getProperty("GG.sms.ipAddr").trim();
            String port = prop.getProperty("GG.sms.port") == null ? "" : prop.getProperty("GG.sms.port").trim();
            String smsClassPath = prop.getProperty("smsClassPath");
            Boolean isPartpayment = (isPartpaymentStr == null || "".equals(isPartpaymentStr)) ? false : Boolean.parseBoolean(isPartpaymentStr);

            PrepaymentLog prepayLog = chargeStore.getPrepayLog(id, meterId);

            Boolean isCancelled = prepayLog.getIsCanceled() == null ? false : prepayLog.getIsCanceled();
            // Cancel된 내역인지 다시 한번 확인
            if (!isCancelled) {
                Integer contractId = prepayLog.getContractId();
                contract = chargeStore.getContractById(contractId);
//                Meter meter = contract.getMeter();
                Meter meter = chargeStore.getMeter(meterId);

                if (prepayLog.getToken() != null && meter.getModel() != null) {
                    vendorName = meter.getModel().getDeviceVendor().getName();
                    modelName = meter.getModel().getName();

                    Double chargedCredit = prepayLog.getChargedCredit() == null ? 0d : prepayLog.getChargedCredit();
                    if (chargedCredit > 0) {
                        /*
                         * Electricity : 0 Water : 1 Gas : 2 Time : 3 Credit(EM)
                         * : 4 Credit(WM) : 5 Credit(GM) : 6 Credit(TIME) : 7
                         */

                        String meterTypeCode = meter.getMeterType();
                        String subClass = "4"; // default 4
                        if ("1.3.1.1".equals(meterTypeCode)) {
                            subClass = "4";
                        } else if ("1.3.1.2".equals(meterTypeCode)) {
                            subClass = "5";
                        }

                        Double currencyUnits = 0.01;
                        chargedCredit = Double.parseDouble(String.format("%.2f", chargedCredit));

                        // for minus token * -1
                        Double value = (-1 * chargedCredit) / currencyUnits;
                        String tokenValue = String.valueOf(Math.round(value));

                        if (modelName.equals("NRAM-1405DR60") || modelName.equals("NRAM-3410DR100") || modelName.contains("OmniPower STS")) {
                            String DSN = null;
                            String TCT = "02";
                            String EA = "07";
                            String tokenDate = DateTimeUtil.getDateString(new Date());
                            String DOE = STSToken.getDOE(tokenDate);
                            String MfrCode = null;
                            String TI = "01";
                            String KRN = "1";

                            if (modelName.contains("OmniPower STS")) {
                                MfrCode = "96"; // SUNI
                            } else {
                                MfrCode = "24"; // WASION
                            }

                            if (meter.getIhdId() != null && (meter.getIhdId().length() == 8 || meter.getIhdId().length() == 11)) {
                                DSN = meter.getIhdId();
                            } else {
                                returnData.put("result", "fail : Cannot find STS Number.");
                                return returnData;
                            }

                            String idRecord = STSToken.getIdRecord(TCT, EA, SGC, KRN, DSN, DOE, MfrCode, TI);
                            String cancelToken = null;
                            // subclass=1이 clearCredit.
                            if (stsBaseUrl != null && !"".equals(stsBaseUrl)) {
                                String sendURL = stsBaseUrl.trim() + "VendCredit.ini?";
                                sendURL += "meterId=" + idRecord + "&subclass=" + subClass + "&value=" + tokenValue;
                                cancelToken = STSToken.makeToken(sendURL);
                            }

                            // token : 20 digit
                            if (cancelToken == null || cancelToken.length() != 20 || cancelToken.contains("Exception")) {
                                returnData.put("result", "fail : Cannot make Cancel Token.");
                                return returnData;
                            } else {
                                returnData.put("token", cancelToken);
                                String createDate = DateTimeUtil.getDateString(new Date());
                                String cmd = null;
                                long trId = 0L;

                                if (modelName.contains("OmniPower STS")) {
                                    // 비동기 내역 저장
                                    cmd = "cmdSetSTSToken";
                                    trId = System.currentTimeMillis();

                                    List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();
                                    Map<String, String> paramMap = new HashMap<String, String>();
                                    paramMap.put("string", cancelToken);
                                    paramList.add(paramMap);

                                    // 모뎀 정보가 있는 경우만 비동기 처리가 가능
                                    /*if (meter.getModem() != null) {
                                        saveAsyncCommandList(meter.getModem().getDeviceSerial(), trId, cmd, paramList, DateTimeUtil.getDateString(new Date()));
                                    }*/
                                } else {
                                    List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();
                                    Map<String, String> paramMap = new HashMap<String, String>();
                                    paramMap.put("string", cancelToken);
                                    paramList.add(paramMap);

                                    cmd = StsConstants.SuniCMD.cmdSetSTSToken.name();
                                    trId = System.currentTimeMillis();
                                    createDate = DateTimeUtil.getDateString(new Date());
                                    if (contract != null) {
                                        createEcgStsLog(contract.getContractNumber(), cmd, createDate, tokenDate, cancelToken, 100, trId, DateTimeUtil.getDateString(new Date()));
                                    }
                                }

                                prepayLog.setCancelToken(cancelToken);
                            }
                        }

                    }
                }

                prepayLog.setIsCanceled(true);
                prepayLog.setCancelDate(TimeUtil.getCurrentTime());
                if (!reason.isEmpty()) {
                    prepayLog.setCancelReason(reason);
                }
                chargeStore.updatePrepaymentLog(prepayLog);

                Operator operator = chargeStore.getOperator(operatorId);
//                Operator commitedVendor = prepayLog.getOperator();

                Double currrentArrears = contract.getCurrentArrears() == null ? 0d : contract.getCurrentArrears();
                Double chargedArrears = prepayLog.getChargedArrears() == null ? 0d : prepayLog.getChargedArrears();
                Double currentCredit = contract.getCurrentCredit() == null ? 0d : contract.getCurrentCredit();
                Double chargedCredit = prepayLog.getChargedCredit() == null ? 0d : prepayLog.getChargedCredit();

                Double arrears = (Double) ObjectUtils.defaultIfNull(currrentArrears + chargedArrears, null);
                Double balance = (Double) ObjectUtils.defaultIfNull(currentCredit - chargedCredit, null);
                List<Map<String, Object>> debtsList = new ArrayList<Map<String, Object>>();

                List<DebtEnt> debtEntList = chargeStore.getDebtEnt(String.valueOf(prepayLog.getCustomerNo()), null, null);
                List<DebtLog> debtLogList = chargeStore.getDebtLog(String.valueOf(prepayLog.getId()));
                for (int i = 0; i < debtEntList.size(); i++) {
                    DebtEnt debtEnt = debtEntList.get(i);
                    for (int j = 0; j < debtLogList.size(); j++) {
                        DebtLog debtLog = debtLogList.get(j);
                        if (debtEnt.getDebtRef().equals(debtLog.getDebtRef())) {
                            Map<String, Object> debts = new HashMap<String, Object>();
                            Double preDebt = debtEnt.getDebtAmount();
                            Double debtAmount = StringUtil.nullToDoubleZero(debtEnt.getDebtAmount())
                                    + debtLog.getChargedDebt();
                            totalAmount += StringUtil.nullToDoubleZero(debtLog.getChargedDebt());
                            debts.put("preDebt", preDebt);
                            debts.put("debtAmount", debtAmount);
                            debts.put("debt", debtEnt);
                            debts.put("debtLog", debtLog);
                            debts.put("debtType", debtEnt.getDebtType());
                            debtsList.add(debts);
                        }
                    }
                }

                totalAmount += StringUtil.nullToDoubleZero(prepayLog.getChargedArrears()) + StringUtil.nullToDoubleZero(prepayLog.getChargedCredit());

               /* if (commitedVendor.getRole().getName().equals("vendor")) {
                    commitedVendor = prepayLog.getOperator();
                    commitedVendor.setDeposit(commitedVendor.getDeposit() + totalAmount);
                    operatorDao.update(commitedVendor);
                }*/

                Double preArrears = contract.getCurrentArrears();
                Double preBalance = contract.getCurrentCredit();
                Double preChargedCredit = contract.getChargedCredit();

                addContractChangeLog(contract, operator, "currentCredit", preBalance, balance, null);
                addContractChangeLog(contract, operator, "currentArrears", preArrears, arrears, null);
                addContractChangeLog(contract, operator, "chargedCredit", preChargedCredit, -totalAmount, null);

               for (int i = 0; i < debtsList.size(); i++) {
                    Map<String, Object> debts = debtsList.get(i);
                    addContractChangeLog(contract, operator, "currentDebts", debts.get("preDebt"), debts.get("debtAmount"), StringUtil.nullToBlank(debts.get("debtType")));
                    DebtEnt debt = (DebtEnt) debts.get("debt");
                    debt.setDebtAmount((Double) debts.get("debtAmount"));
                    chargeStore.updateDebtEnt(debt);
                }

                contract.setCurrentCredit(balance);
                contract.setCurrentArrears(arrears);
                // 수정 전 소스의 프로세스대로 수정했으나 본래 모델에 정의된 본래 사용의도와 동일하지 않음.
                contract.setChargedCredit(-totalAmount);
                chargeStore.updateContract(contract);

                for (int i = 0; i < debtsList.size(); i++) {
                    Map<String, Object> debts = debtsList.get(i);
                    DebtEnt debt = (DebtEnt) debts.get("debt");
                    Double debtAmount = (Double) debts.get("debtAmount");

                    debt.setDebtAmount(debtAmount);
                    chargeStore.updateDebtEnt(debt);
                }

                // token 전송 (S)
                try {
                    String token = returnData.get("token").toString();
                    String mdsId = returnData.get("meterId").toString();
                    log.info("## Token Retry: meter number[" + mdsId + "] token[" + token + "]");

                    if (sendSTSToken(uuid, mdsId, token, chargeId, timeout, callBackURI) == "success") {
                        returnData.put("ResultDetail", "token gen:" + true + ", set:" + true);
//                returnData.put("result", "success");
                    }

                    APICallBackHistory history = new APICallBackHistory();
                    history.setMdevId(meterId);
//            history.setOperatorId(operatorId);
                    history.setTid(chargeId);
                    history.setCallBackURI(callBackURI);
                    history.setColumn01(String.valueOf(paidAmount)); //충전일 경우 column01 항목에 내용을 저장한다.
                    if(returnData != null && !returnData.isNull("prepaymentId")) {
                        history.setPrepaymentLogId(Long.parseLong(returnData.get("prepaymentId").toString()));
                    }

                    updateCallbackHistory(uuid, history);
                } catch (Exception e) {
                    APICallBackHistory history = new APICallBackHistory();
                    history.setMdevId(meterId);
//            history.setOperatorId(operatorId);
                    history.setTid(chargeId);
                    history.setCallBackURI(callBackURI);
                    history.setColumn01(String.valueOf(paidAmount)); //충전일 경우 column01 항목에 내용을 저장한다.
                    history.setDescr("Exception : " + e.getMessage());
                    updateCallbackHistory(uuid, history);

                    returnData.put("code", ETKConstants.ErrorType.failToSendSTSToken.getIntValue());
                    returnData.put("msgUser", ETKConstants.ErrorType.failToSendSTSToken);
                    returnData.put("msgDeveloper", e.getMessage());
                    return returnData;
                }
                // token 전송 (E)

            } else {
                rtn = "canceled Data";
            }
        } catch (Exception e) {
            log.error(e, e);
            rtn = "failed";
        }

        returnData.put("result", rtn);
        return returnData;
    }

    protected String sendSTSToken(String uuid, String mdsId, String tokenNum, String chargeId, int timeout, String callBackURI) {
        String result = "fail";
        try {
            CmdSendToken cmdSendToken = new CmdSendToken();

            cmdSendToken.setUuid(uuid);
            cmdSendToken.setMeterId(mdsId);
            cmdSendToken.setChargeType(ETKConstants.ChargeType.Charge);
            cmdSendToken.setDlmsReqType(StsConstants.DLMS_REQUEST_TYPE.ACT);
            cmdSendToken.setToken(tokenNum);
            cmdSendToken.setChargeId(chargeId);
            cmdSendToken.setAmount(timeout);
            cmdSendToken.setCallbackURI(callBackURI);

            asyncQueueHandler.putServiceData(AsyncQueueHandler.SERVICE_ETK_SEND_TOKEN, cmdSendToken);

            result = "success";
        } catch (Exception e) {
            log.error(e, e);
        }

        return result;
    }

    public void updateCallbackHistory(String uuid, APICallBackHistory apiCallBackHistory) {
        try {

            APICallBackHistory queryHistory = chargeStore.getCallbackHistory(uuid);
            if(queryHistory != null) {
                if(apiCallBackHistory.getUrl() != null)
                    queryHistory.setUrl(apiCallBackHistory.getUrl());

                if(apiCallBackHistory.getMethod() != null)
                    queryHistory.setMethod(apiCallBackHistory.getMethod());

                if(apiCallBackHistory.getUrl() != null)
                    queryHistory.setUrl(apiCallBackHistory.getUrl());

                if(apiCallBackHistory.getTid() != null)
                    queryHistory.setTid(apiCallBackHistory.getTid());

                if(apiCallBackHistory.getSourceIP() != null)
                    queryHistory.setSourceIP(apiCallBackHistory.getSourceIP());

                if(apiCallBackHistory.getCallBackURI() != null)
                    queryHistory.setCallBackURI(apiCallBackHistory.getCallBackURI());

                if(apiCallBackHistory.getCallBackURL() != null)
                    queryHistory.setCallBackURL(apiCallBackHistory.getCallBackURL());

                if(apiCallBackHistory.getCallBackCnt() != null)
                    queryHistory.setCallBackCnt(apiCallBackHistory.getCallBackCnt());

                if(apiCallBackHistory.getResponseStatus() != null)
                    queryHistory.setResponseStatus(apiCallBackHistory.getResponseStatus());

                if(apiCallBackHistory.getResponseBody() != null)
                    queryHistory.setResponseBody(apiCallBackHistory.getResponseBody());

                if(apiCallBackHistory.getPrepaymentLogId() != null)
                    queryHistory.setPrepaymentLogId(apiCallBackHistory.getPrepaymentLogId());

                if(apiCallBackHistory.getMdevId() != null)
                    queryHistory.setMdevId(apiCallBackHistory.getMdevId());

//                if(apiCallBackHistory.getOperatorId() != null)
//                    queryHistory.setOperatorId(apiCallBackHistory.getOperatorId());

                if(apiCallBackHistory.getDescr() != null)
                    queryHistory.setDescr(apiCallBackHistory.getDescr());

                queryHistory.setColumn01(apiCallBackHistory.getColumn01());
                queryHistory.setColumn02(apiCallBackHistory.getColumn02());
                queryHistory.setColumn03(apiCallBackHistory.getColumn03());
                queryHistory.setColumn04(apiCallBackHistory.getColumn04());
                queryHistory.setColumn05(apiCallBackHistory.getColumn05());
                queryHistory.setColumn06(apiCallBackHistory.getColumn06());
                queryHistory.setColumn07(apiCallBackHistory.getColumn07());
                queryHistory.setColumn08(apiCallBackHistory.getColumn08());
                queryHistory.setColumn09(apiCallBackHistory.getColumn09());
                queryHistory.setColumn10(apiCallBackHistory.getColumn10());

                queryHistory.setUpdatDate(DateTimeUtil.getDateString(new Date()));

                chargeStore.updateCallbackHistory(queryHistory);
            }

        }catch(Exception e) {
            log.error(e,e);
        }
    }

    private void addContractChangeLog(Contract contract, Operator operator, String field, Object beforeValue,
                                      Object afterValue, String type) throws Exception {

        // ContractChangeLog Insert
        ContractChangeLog contractChangeLog = new ContractChangeLog();

        contractChangeLog.setContractId(contract.getId());
        contractChangeLog.setCustomerId(Integer.valueOf(contract.getCustomerId()));
        contractChangeLog.setStartDatetime(DateTimeUtil.getCurrentDateTimeByFormat("yyyyMMddHHmmss"));
        contractChangeLog.setChangeField(field);

        if (beforeValue == null) {
            contractChangeLog.setBeforeValue(null);
        } else {
            if (type != null) {
                contractChangeLog.setBeforeValue("[" + type + "] " + StringUtil.nullToBlank(beforeValue));
            } else {
                contractChangeLog.setBeforeValue(StringUtil.nullToBlank(beforeValue));
            }
        }

        if (afterValue == null) {
            contractChangeLog.setAfterValue(null);
        } else {
            if (type != null) {
                contractChangeLog.setAfterValue("[" + type + "] " + StringUtil.nullToBlank(afterValue));
            } else {
                contractChangeLog.setAfterValue(StringUtil.nullToBlank(afterValue));
            }

        }

//        contractChangeLog.setOperator(operator);
        contractChangeLog.setWriteDatetime(DateTimeUtil.getCurrentDateTimeByFormat("yyyyMMddHHmmss"));

        chargeStore.addContractChangeLog(contractChangeLog);
    }

    private void createEcgStsLog(String meterNumber, String cmd, String createDate, String tokenDate, String token,
                                 Integer result, long asyncTrId, String asyncCreateDate) {
        try {
            EcgSTSLog stslog = new EcgSTSLog();
            stslog.setCmd(cmd);
            stslog.setAsyncTrId(asyncTrId);
            stslog.setMeterNumber(meterNumber);
            stslog.setCreateDate(createDate);
            stslog.setGetDate(asyncCreateDate);
            stslog.setResult(result);
            stslog.setTokenDate(tokenDate);
            stslog.setToken(token);
            stslog.setSeq(0);
            stslog.setResultDate(stslog.getCreateDate());
            chargeStore.addSTSlog(stslog);
        } catch (Exception e) {
            log.error(e, e);
        }
    }

    private String cmdMsg(byte seq, String oid, String ip, String port) {
        int sequence = (int) (seq & 0xFF);
        String smsMsg = "NT,";
        if (sequence >= 10 && sequence < 100) {
            smsMsg += "0" + sequence;
        } else if (sequence < 10) {
            smsMsg += "00" + sequence;
        } else {
            smsMsg += "" + sequence;
        }
        smsMsg += ",Q,B," + oid + "," + ip + "," + port;

        return smsMsg;
    }
}
