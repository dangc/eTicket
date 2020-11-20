package com.nuri.etk.logic;

import com.nuri.etk.entity.API.Charge;
import com.nuri.etk.entity.aimir.*;
import com.nuri.etk.entity.pojo.ArrearsDebt;
import com.nuri.etk.entity.pojo.ChargeInfo;
import com.nuri.etk.spec.ChargeService;
import com.nuri.etk.store.ChargeStore;
import com.nuri.etk.store.CodeStore;
import com.nuri.etk.util.DateTimeUtil;
import com.nuri.etk.util.STSToken;
import com.nuri.etk.util.StringUtil;
import com.nuri.etk.util.TimeUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ChargeLogic implements ChargeService {

    private final ChargeStore chargeStore;
    private final CodeStore codeStore;

    public ChargeLogic(ChargeStore chargeStore, CodeStore codeStore) {
        this.chargeStore = chargeStore;
        this.codeStore = codeStore;
    }

    @Override
    public Charge meterCharge(String meterId, HttpHeaders headers, ChargeInfo chargeInfo) {
        Charge charge = new Charge();
        String result = null;
        String token = null;

        Map<String, Object> resultMap = balanceCharge(meterId, chargeInfo);
        result = (String) resultMap.get("result");
//        token = (String) resultMap.get("token");

        if (result.equals("success")) {
            charge.setCode(200);
        }
        charge.setResultDetail(result);
//        charge.setResultDetail(token);
        return charge;

    }

    private Map<String, Object> balanceCharge(String meterId, ChargeInfo condition) {
        Map<String, Object> result = new HashMap<String, Object>();
        Integer contractId = null;
        String contractNumber = null;
//        Integer payTypeId = (Integer) condition.get("payTypeId");
        String customerNo = null;
        Boolean isPartpayment = false;

        String mdsId = StringUtil.nullToBlank(meterId);
        String operatorId = condition.getOperatorId();
        Double paidAmount = Double.parseDouble(condition.getPaidAmount());
        Double chargedCredit = Double.parseDouble(condition.getChargedCredit());
        Double chargedArrears = Double.parseDouble(condition.getChargedArrears());
        List<ArrearsDebt> currentDebtList = (List<ArrearsDebt>) condition.getDebt();
        Map<String, Object> smsInfo = new HashMap<String, Object>();
        String modelName = null;
        String vendorName = null;
        String rtnStr = "";

//        log.info(condition);

        try {
            if (chargedCredit < 0.0) {
                result.put("result", "fail : charged credit(" + chargedCredit + ") is negative, try again");
                return result;
            }

            if (paidAmount < 0.0) {
                result.put("result", "fail : paid amount(" + paidAmount + ") is negative, try again");
                return result;
            }

            Meter meter = chargeStore.getMeter(mdsId);

            Contract contract = null;
            List<DebtEnt> debtEntList = null;
            Map<String, Object> conditionMap = new HashMap<String, Object>();

//            conditionMap.put("contractNumber", contractNumber);
            conditionMap.put("mdsId", mdsId);

            // select Contract
            contract = chargeStore.getContract(mdsId);
            customerNo = contract.getCustomerId();
            debtEntList = chargeStore.getDebt(customerNo, null, null);

            if (contract == null) {
                result.put("result", "fail : Invalid contract Info.");
                return result;
            }
            Operator updateOperator = chargeStore.getOperator(operatorId);
//            Double currentDeposit = updateOperator.getDeposit();
//
//            if (currentDeposit == null || currentDeposit < paidAmount) {
//                // 잔고 부족
//                result.put("result", "fail : Insufficient Quota Balance.");
//                return result;
//            }

            String token = null;
            if (meter != null && meter.getModel() != null && chargedCredit != 0d) { // 미수금을 제외한 실제 충전금액이 0이면 토큰을 발행하지않는다.
//            if (chargedCredit != 0d) { // 미수금을 제외한 실제 충전금액이 0이면 토큰을 발행하지않는다.
                if (contract.getTariffIndexId() == null) {
                    // Tariff가 설정되어있지 않으면 토큰 발급하지 않는다.
                    result.put("result", "fail : Contract has no tariff type.");
                    return result;
                }

                modelName = meter.getModel().getName();
                vendorName = meter.getModel().getDeviceVendor().getName();

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

                if (modelName.equals("NRAM-1405DR60") || modelName.equals("NRAM-3410DR100") || modelName.contains("OmniPower STS")) {
                    // value format : A decimal integer greater than 0.
                    // base currency units : 0.01, R50.01 금액 충전시 value는 5001로 넣어야한다.
                    Double currencyUnits = 0.01;
                    Double chargedFormatCredit = Double.parseDouble(String.format("%.2f", chargedCredit));

                    Double value = chargedFormatCredit / currencyUnits;
                    String tokenValue = String.valueOf(Math.round(value));


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
                        result.put("result", "fail : Cannot find STS Number.");
                        return result;
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
                        result.put("result", "fail : Cannot make Token.");
                        return result;
                    } else {
                        String createDate = DateTimeUtil.getDateString(new Date());
                        String cmd = null;
                        long trId = 0L;

                        if (modelName.contains("OmniPower STS")) {
                            // 비동기 내역 저장
                            cmd = "cmdSetSTSToken";
                            trId = System.currentTimeMillis();

                            List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();
                            Map<String, String> paramMap = new HashMap<String, String>();
                            paramMap.put("string", token);
                            paramList.add(paramMap);

                            // 모뎀 정보가 있는 경우만 비동기 처리가 가능
                            if (meter.getModem() != null) {
                                saveAsyncCommandList(meter.getModem().getDeviceSerial(), trId, cmd, paramList, DateTimeUtil.getDateString(new Date()));
                            }
                        } else {
                            List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();
                            Map<String, String> paramMap = new HashMap<String, String>();
                            paramMap.put("string", token);
                            paramList.add(paramMap);

                            cmd = StsConstants.SuniCMD.cmdSetSTSToken.name();
                            trId = System.currentTimeMillis();
                        }

                        createEcgStsLog(meter.getMdsId(), cmd, createDate, tokenDate, token, 100, trId, DateTimeUtil.getDateString(new Date()));
                        smsInfo.put("token", token);
                    }

                    if (!"".equals(ipAddr) && !"".equals(port)) {
                        if (meter.getModem() != null) {
                            smsInfo.put("modemId", meter.getModemId());
                            smsInfo.put("deviceSerial", meter.getModem().getDeviceSerial());
                        }
                        smsInfo.put("ipAddr", ipAddr);
                        smsInfo.put("port", port);
                        smsInfo.put("smsClassPath", smsClassPath);
                        smsInfo.put("prop", prop);
                        int seq = new Random().nextInt(100) & 0xFF;
                        String smsMsg = cmdMsg((byte) seq, "244.0.0", ipAddr.replaceAll("\\.", ","), port);
                        smsInfo.put("smsMsg", smsMsg);
                    }
                }
            }

            String lastChargeDate = StringUtil.nullToBlank(contract.getLastTokenDate());
            Double preCredit = StringUtil.nullToDoubleZero(contract.getCurrentCredit());
            Double currentCredit = new BigDecimal(StringUtil.nullToZero(contract.getCurrentCredit())).add(new BigDecimal(StringUtil.nullToZero(chargedCredit))).doubleValue();

            Boolean isCutOff = false; // 차단여부

            if (meter != null && meter.getModel() != null && currentCredit > 0d && meter.getMeterStatusCodeId() != null) {
                Code code = chargeStore.getMeterStatusCode(meter.getMeterStatusCodeId());
                isCutOff = code.getCode().equals("1.3.3.4");
            }

            Integer lastChargeCnt = new Integer(StringUtil.nullToZero(contract.getLastChargeCnt())) + 1;
            Code keyCode = null;
            Operator operator = chargeStore.getOperator(operatorId);
            // insert ContractChangeLog
            addContractChangeLog(contract, operator, "lastTokenDate", contract.getLastTokenDate(), DateTimeUtil.getCurrentDateTimeByFormat("yyyyMMddHHmmss"), null);
            addContractChangeLog(contract, operator, "chargedCredit", contract.getChargedCredit(), paidAmount, null);
            addContractChangeLog(contract, operator, "currentCredit", contract.getCurrentCredit(), currentCredit.toString(), null);
            addContractChangeLog(contract, operator, "lastChargeCnt", contract.getLastChargeCnt(), lastChargeCnt.toString(), null);

            contract.setLastTokenDate(DateTimeUtil.getCurrentDateTimeByFormat("yyyyMMddHHmmss"));
            contract.setChargedCredit(paidAmount);
            contract.setCurrentCredit(currentCredit);
            contract.setLastChargeCnt(lastChargeCnt);
            contract.setCashPoint(operator.getCashPoint());

            PrepaymentLog prepaymentLog = new PrepaymentLog();
            List<DebtLog> debtLogList = new ArrayList<DebtLog>();

            if (isPartpayment) {
                Map<String, Object> partpayResult = partpayManagement(contract, debtEntList, currentDebtList, operator, customerNo);
                contract = (Contract) partpayResult.get("contract");
                debtEntList = (List<DebtEnt>) partpayResult.get("debtEntList");
                prepaymentLog = (PrepaymentLog) partpayResult.get("prepaymentLog");
                debtLogList = (List<DebtLog>) partpayResult.get("debtLogList");
            } else {
                Double preArrears = contract.getCurrentArrears();
                prepaymentLog.setArrears(preArrears);
                prepaymentLog.setPreArrears(preArrears);
                prepaymentLog.setChargedArrears(0d);
                for (int i = 0; i < currentDebtList.size(); i++) {
                    Map<String, Object> map = new HashMap<>();
                    map = currentDebtList.stream().collect(Collectors.toMap(ArrearsDebt::getDebtRef, arrearsDebt -> arrearsDebt));
                    Double payAmount = map.get("payAmount") != null ? Double.parseDouble(map.get("payAmount").toString()) : 0.0;

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
                                emptyDebtLog.setPartpayInfo(StringUtil.nullToZero(debtEnt.getDebtPaymentCount()) + "/" + debtEnt.getDebtPaymentCount());
                            }
                            debtLogList.add(emptyDebtLog);
                        }
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

//            Code keyType = codeStore.getkeyType(payTypeId);
            Code keyType = null;

            if (token != null && !"".equals(token)) {
                prepaymentLog.setToken(token);
            }
            prepaymentLog.setDaysFromCharge(daysFromCharge);
            prepaymentLog.setCustomer(contract.getCustomer());
            prepaymentLog.setContract(contract);
            prepaymentLog.setKeyType(keyCode);
            prepaymentLog.setChargedCredit(chargedCredit);
            prepaymentLog.setLastTokenDate(DateTimeUtil.getCurrentDateTimeByFormat("yyyyMMddHHmmss"));
            prepaymentLog.setOperator(operator);
            Integer emergencyYn = null;
            if (contract.getEmergencyCreditAvailable() != null) {
                emergencyYn = (contract.getEmergencyCreditAvailable()) ? 1 : 0;
            }
            prepaymentLog.setEmergencyCreditAvailable(emergencyYn);
            prepaymentLog.setPreBalance(preCredit);
            prepaymentLog.setBalance(currentCredit);
            prepaymentLog.setLocation(contract.getLocation());
            prepaymentLog.setTariffIndex(contract.getTariffIndex());
            prepaymentLog.setPayType(keyType);

            // Prepaymentlog의 ID 생성방법 변경(id+시스템시간)
            prepaymentLog.setId(Long.parseLong(Integer.toString(contract.getId()) + Long.toString(System.currentTimeMillis())));
            chargeStore.addPrepaymentLog(prepaymentLog);

//            log.info("prepaymentLog has been added");

            DepositHistory dh = new DepositHistory();
            dh.setOperator(updateOperator);
            dh.setContract(contract);
            dh.setCustomer(contract.getCustomer());
            dh.setMeter(meter);
            dh.setChangeDate(DateTimeUtil.getCurrentDateTimeByFormat("yyyyMMddHHmmss"));
            dh.setChargeCredit(paidAmount);
            dh.setDeposit(updateOperator.getDeposit());
            dh.setPrepaymentLog(prepaymentLog);

            chargeStore.addDepositHistory(dh);

            for (int i = 0; i < debtLogList.size(); i++) {
                DebtLog debtLog = (DebtLog) debtLogList.get(i);
                debtLog.setPrepaymentLog(prepaymentLog);
                chargeStore.addDebtLog(debtLog);
            }

            chargeStore.updateOperator(updateOperator);
//            log.info("operator update is completed");

            for (int i = 0; i < debtEntList.size(); i++) {
                chargeStore.updateDebtEnt((DebtEnt) debtEntList.get(i));
            }

            // update Contract
            chargeStore.updateContract(contract);

//            log.info("contractInfo has been updated");
//            log.info("depositHistory has been added");

            smsInfo.put("modelName", modelName);
            smsInfo.put("contract", contract);
            smsInfo.put("chargedCredit", chargedCredit);
            smsInfo.put("preCredit", preCredit);
            smsInfo.put("isCutOff", isCutOff);

            rtnStr = "success";
            result.put("result", rtnStr);
            result.put("prepaymentLogId", prepaymentLog.getId());
            result.put("isCutOff", isCutOff);
            result.put("credit", currentCredit);
            result.put("smsInfo", smsInfo);
            return result;
        } catch (Exception e) {
//            log.error(e, e);

            e.printStackTrace();
            rtnStr = "fail";

            result.put("result", rtnStr);
            return result;
        }
    }

    private void saveAsyncCommandList(String deviceSerial, long trId, String cmd, List<Map<String, String>> paramList,
                                      String currentTime) throws Exception {
        AsyncCommandLog asyncCommandLog = new AsyncCommandLog();
        asyncCommandLog.setTrId(trId);
        asyncCommandLog.setMcuId(deviceSerial);
        asyncCommandLog.setDeviceType(CommonConstants.McuType.MMIU.name());
        asyncCommandLog.setDeviceId(deviceSerial);
        asyncCommandLog.setCommand(cmd);
        asyncCommandLog.setTrOption(CommonConstants.TR_OPTION.ASYNC_OPT_RETURN_DATA_SAVE.getCode());
        asyncCommandLog.setState(CommonConstants.TR_STATE.Waiting.getCode());
        asyncCommandLog.setOperator(CommonConstants.OperatorType.OPERATOR.name());
        asyncCommandLog.setCreateTime(currentTime);
        asyncCommandLog.setRequestTime(currentTime);
        asyncCommandLog.setLastTime(null);
        chargeStore.addAsyncCommandLog(asyncCommandLog);
        Integer num = 0;
        if (paramList != null && paramList.size() > 0) {
            // parameter가 존재할 경우.
            Integer maxNum = chargeStore.getMaxNum(deviceSerial, trId);
            if (maxNum != null)
                num = maxNum + 1;

            for (int i = 0; i < paramList.size(); i++) {
                Map<String, String> param = paramList.get(i);
                Iterator<String> iter = param.keySet().iterator();
                while (iter.hasNext()) {
                    String key = iter.next();

                    AsyncCommandParam asyncCommandParam = new AsyncCommandParam();
                    asyncCommandParam.setMcuId(deviceSerial);
                    asyncCommandParam.setNum(num);
                    asyncCommandParam.setParamType(key);
                    asyncCommandParam.setParamValue((String) param.get(key));
                    asyncCommandParam.setTrId(trId);

                    chargeStore.addAsyncCommandParam(asyncCommandParam);
                    num += 1;
                }
            }
        }
    }

    private void addContractChangeLog(Contract contract, Operator operator, String field, Object beforeValue,
                                      Object afterValue, String type) {

        // ContractChangeLog Insert
        ContractChangeLog contractChangeLog = new ContractChangeLog();

        contractChangeLog.setContract(contract);
        contractChangeLog.setCustomer(contract.getCustomer());
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

        contractChangeLog.setOperator(operator);
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
//            log.error(e, e);
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

    public Map<String, Object> partpayManagement(Contract contract, List<DebtEnt> preDebtList,
                                                 List<ArrearsDebt> debtList, Operator operator, String customerNo) throws Exception {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        PrepaymentLog prepaymentLog = new PrepaymentLog();
        List<DebtLog> debtLogList = new ArrayList<DebtLog>();

        Double preArrears = StringUtil.nullToDoubleZero(contract.getCurrentArrears());
        prepaymentLog.setPreArrears(preArrears);
        prepaymentLog.setArrears(preArrears);
        prepaymentLog.setChargedArrears(0d);

        Integer tempPaymentCount = null;
        Integer prePaymentCount = null;
        Integer preContractCount = null;
        for (int i = 0; i < debtList.size(); i++) {
            Map<String, Object> map = (Map<String, Object>) debtList.get(i);
            Double partCredit = map.get("partCredit") != null ? Double.parseDouble(map.get("partCredit").toString())
                    : 0.0;
            Double payAmount = map.get("payAmount") != null ? Double.parseDouble(map.get("payAmount").toString()) : 0.0;

            if (((String) map.get("debtType")).equals("Arrears")) {
                Double currentArrears = new BigDecimal(StringUtil.nullToDoubleZero(preArrears))
                        .subtract(new BigDecimal(payAmount)).doubleValue();
                contract.setCurrentArrears(currentArrears);

                preArrears = contract.getCurrentArrears();
                prePaymentCount = contract.getArrearsPaymentCount();
                // charge하는 경우 타는 소스이므로 첫 charge시에는 arrearsPaymentCount가 1이되어야
                // 한다.
                tempPaymentCount = prePaymentCount == null ? 1 : prePaymentCount + 1;
                contract.setArrearsPaymentCount(tempPaymentCount);

                // 분할 납부금액 초기화
                if ((partCredit < payAmount) && contract.getArrearsContractCount() != null) {
                    Double preFirstArrears = contract.getFirstArrears();
                    preContractCount = contract.getArrearsContractCount();

                    contract.setFirstArrears(currentArrears);
                    contract.setArrearsContractCount(
                            contract.getArrearsContractCount() - contract.getArrearsPaymentCount());
                    contract.setArrearsPaymentCount(0);

                    addContractChangeLog(contract, operator, "firstArrears", preFirstArrears,
                            contract.getFirstArrears(), null);
                    addContractChangeLog(contract, operator, "arrearsContractCount", preContractCount,
                            contract.getArrearsContractCount(), null);
                }

                // 미수금을 모두 갚았을 경우 || 미수금이 없을 경우
                if ((currentArrears <= 0 || currentArrears == null) || contract.getArrearsContractCount() == null) {
                    Integer preACC = contract.getArrearsContractCount();
                    Double preFA = contract.getFirstArrears();

                    contract.setArrearsPaymentCount(null);
                    contract.setArrearsContractCount(null);
                    contract.setFirstArrears(null);

                    addContractChangeLog(contract, operator, "firstArrears", preFA, null, null);
                    addContractChangeLog(contract, operator, "arrearsContractCount", preACC, null, null);
                }

                addContractChangeLog(contract, operator, "currentArrears", preArrears, contract.getCurrentArrears(),
                        null);
                addContractChangeLog(contract, operator, "arrearsPaymentCount", prePaymentCount,
                        contract.getArrearsPaymentCount(), null);
                if ((preArrears > 0) && contract.getArrearsContractCount() != null
                        && contract.getArrearsPaymentCount() != null) {
                    prepaymentLog.setPartpayInfo(
                            contract.getArrearsPaymentCount() + "/" + contract.getArrearsContractCount());
                }

                // prepaymentLog.setPreArrears(preArrears);
                prepaymentLog.setArrears(currentArrears);
                prepaymentLog.setChargedArrears(payAmount);

            } else {
                Double tempCurrentDebt = 0.0;
                for (int j = 0; j < preDebtList.size(); j++) {
                    DebtEnt tempDebtEnt = preDebtList.get(j);
                    DebtLog debtLog = new DebtLog();
                    if (tempDebtEnt.getDebtRef().equals(StringUtil.nullToBlank(map.get("debtRef").toString()))) {
                        Double preDebt = tempDebtEnt.getDebtAmount();
                        tempCurrentDebt = new BigDecimal(StringUtil.nullToDoubleZero(preDebt))
                                .subtract(new BigDecimal(payAmount)).doubleValue();

                        prePaymentCount = tempDebtEnt.getDebtPaymentCount();
                        tempPaymentCount = prePaymentCount == null ? 1 : prePaymentCount + 1;
                        tempDebtEnt.setDebtPaymentCount(tempPaymentCount);
                        tempDebtEnt.setDebtAmount(tempCurrentDebt);

                        // 분할 납부금액 초기화
                        if (partCredit < payAmount) {
                            Double preFirstDebt = tempDebtEnt.getFirstDebt();
                            preContractCount = tempDebtEnt.getDebtContractCount();

                            tempDebtEnt.setFirstDebt(tempCurrentDebt);
                            tempDebtEnt.setDebtContractCount(
                                    tempDebtEnt.getDebtContractCount() - tempDebtEnt.getDebtPaymentCount());
                            tempDebtEnt.setDebtPaymentCount(0);

                            addContractChangeLog(contract, operator, "firstDebt", preFirstDebt,
                                    tempDebtEnt.getFirstDebt(), tempDebtEnt.getDebtType());
                            addContractChangeLog(contract, operator, "debtContractCount", preContractCount,
                                    tempDebtEnt.getDebtContractCount(), tempDebtEnt.getDebtType());
                        }

                        // 미수금을 모두 갚았을 경우 || 미수금이 없을 경우
                        if ((tempCurrentDebt <= 0 || tempCurrentDebt == null)
                                || tempDebtEnt.getDebtContractCount() == null) {
                            Integer preDCC = tempDebtEnt.getDebtContractCount();
                            Double preFD = tempDebtEnt.getFirstDebt();

                            tempDebtEnt.setFirstDebt(null);
                            tempDebtEnt.setDebtContractCount(null);
                            tempDebtEnt.setDebtPaymentCount(null);

                            addContractChangeLog(contract, operator, "firstDebt", preFD, null,
                                    tempDebtEnt.getDebtType());
                            addContractChangeLog(contract, operator, "debtContractCount", preDCC, null,
                                    tempDebtEnt.getDebtType());
                        }

                        addContractChangeLog(contract, operator, "debtAmount", preDebt, tempDebtEnt.getDebtAmount(),
                                tempDebtEnt.getDebtType());
                        addContractChangeLog(contract, operator, "debtPaymentCount", prePaymentCount,
                                tempDebtEnt.getDebtPaymentCount(), tempDebtEnt.getDebtType());

                        if ((preDebt > 0) && tempDebtEnt.getDebtContractCount() != null
                                && tempDebtEnt.getDebtPaymentCount() != null) {
                            debtLog.setPartpayInfo(
                                    tempDebtEnt.getDebtPaymentCount() + "/" + tempDebtEnt.getDebtContractCount());
                        }

                        debtLog.setPreDebt(preDebt);
                        debtLog.setDebt(tempCurrentDebt);
                        debtLog.setChargedDebt(payAmount);
                        debtLog.setDebtRef(map.get("debtRef").toString());
                        debtLog.setCustomerId(customerNo);
                        debtLog.setDebtType(map.get("debtType").toString());
                        debtLogList.add(debtLog);
                        preDebtList.set(j, tempDebtEnt);
                    }
                }
            }
        }

        if (debtLogList.size() < preDebtList.size()) {
            List<DebtLog> tempLogList = new ArrayList<DebtLog>();
            for (int j = 0; j < debtLogList.size(); j++) {
                tempLogList.add(debtLogList.get(j));
            }

            for (int i = 0; i < preDebtList.size(); i++) {
                boolean flag = false;
                DebtEnt debtEnt = preDebtList.get(i);
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
                                + debtEnt.getDebtContractCount());
                    }
                    debtLogList.add(emptyDebtLog);
                }
            }
        }

        returnMap.put("contract", contract);
        returnMap.put("debtEntList", preDebtList);
        returnMap.put("prepaymentLog", prepaymentLog);
        returnMap.put("debtLogList", debtLogList);

        return returnMap;

    }
}
