package com.nuri.etk.store;

import com.nuri.etk.entity.aimir.*;
import com.nuri.etk.entity.pojo.ChargeInfo;
import com.nuri.etk.entity.pojo.PaymentInfo;
import org.springframework.http.HttpHeaders;

import java.util.List;

public interface ChargeStore {
    public ChargeInfo meterCharge(String meterId, HttpHeaders headers, ChargeInfo chargeInfo);

    Meter getMeter(String meterId);

    MCU getMCU(String meterId);

    Contract getContract(String meterId);

    List<DebtEnt> getDebtEnt(String customerNo, String debtType, String debtRef);

    List<DebtLog> getDebtLog(String id);

    Operator getOperator(String operatorId);

    Code getMeterStatusCode(Integer meterStatusCodeId);

    void addPrepaymentLog(PrepaymentLog prepaymentLog);

    void addDepositHistory(DepositHistory dh);

    void addDebtLog(DebtLog debtLog);

    void updateOperator(Operator updateOperator);

    void updateDebtEnt(DebtEnt debtEnt);

    void updateContract(Contract contract);

    void addAsyncCommandLog(AsyncCommandLog asyncCommandLog);

    Integer getMaxNum(String deviceSerial, long trId);

    void addAsyncCommandParam(AsyncCommandParam asyncCommandParam);

    void addContractChangeLog(ContractChangeLog contractChangeLog);

    void addSTSlog(EcgSTSLog stslog);

    APICallBackHistory getCallbackHistory(String uuid);

    APICallBackHistory getAPICallBackHistory(String uuid);

    Contract getContractById(Integer contractId);

    Supplier getSupplier(Integer supplierId);

    PrepaymentLog getPrepayLog(String id, String meterId);

    void updateCallbackHistory(APICallBackHistory queryHistory);

    void updatePrepaymentLog(PrepaymentLog prepayLog);
}