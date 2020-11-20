package com.nuri.etk.store.mapper;

import com.nuri.etk.store.jpo.aimir.ContractJpo;
import com.nuri.etk.store.jpo.aimir.DeviceModelJpo;
import com.nuri.etk.store.jpo.aimir.DeviceVendorJpo;
import com.nuri.etk.store.jpo.aimir.MeterJpo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChargeMapper {
    DeviceModelJpo getMeterDeviceModel(String meterId) throws Exception;
    DeviceVendorJpo getMeterDeviceVendor(String meterId) throws Exception;
    MeterJpo getMeterById(String meterId) throws Exception;
    ContractJpo getContract(String meterId) throws Exception;
}