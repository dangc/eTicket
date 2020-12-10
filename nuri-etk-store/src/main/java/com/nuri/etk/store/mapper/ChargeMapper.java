package com.nuri.etk.store.mapper;

import com.nuri.etk.entity.aimir.*;
import com.nuri.etk.store.jpo.PaymentInfoJpo;
import com.nuri.etk.store.jpo.aimir.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChargeMapper {
    DeviceModelJpo getMeterDeviceModel(String meterId) throws Exception;
    DeviceVendorJpo getMeterDeviceVendor(String meterId) throws Exception;
    MeterJpo getMeterById(String meterId) throws Exception;
    ModemJpo getMeterModem(String meterId) throws Exception;
    ContractJpo getContract(String meterId) throws Exception;
    MCUJpo getMCU(String meterId) throws Exception;
    PrepaymentLogJpo getPrepayLog(String id, String meterId) throws Exception;
    ContractJpo getContractById(Integer contractId);
    List<DebtEntJpo> getDebtEnt(String customerNo, String debtType, String debtRef);
    List<DebtLogJpo> getDebtLog(String id);

    void addPrepaymentLog(PrepaymentLog prepaymentLog);
    void addDepositHistory(DepositHistory dh);
    void addDebtLog(DebtLog debtLog);
    void addAsyncCommandLog(AsyncCommandLog asyncCommandLog);
    void addContractChangeLog(ContractChangeLog contractChangeLog);
    void addSTSlog(EcgSTSLog stslog);
    void updateContract(Contract contract);
    void updateDebtEnt(DebtEnt debtEnt);
    void updatePrepaymentLog(PrepaymentLog prepayLog);
}