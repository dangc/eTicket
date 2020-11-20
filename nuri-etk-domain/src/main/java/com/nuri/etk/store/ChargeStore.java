package com.nuri.etk.store;

import com.nuri.etk.entity.aimir.*;
import com.nuri.etk.entity.pojo.ChargeInfo;
import org.springframework.http.HttpHeaders;

import java.util.List;

public interface ChargeStore {
    public ChargeInfo meterCharge(String meterId, HttpHeaders headers, ChargeInfo chargeInfo);

    Meter getMeter(String meterId);

    Contract getContract(String meterId);

    List<DebtEnt> getDebt(String customerNo, String debtType, String debtRef);

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
}