package com.nuri.etk.store.mapper;

import com.nuri.etk.store.jpo.PaymentInfoJpo;
import com.nuri.etk.store.jpo.aimir.*;
import org.apache.ibatis.annotations.Mapper;

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
}