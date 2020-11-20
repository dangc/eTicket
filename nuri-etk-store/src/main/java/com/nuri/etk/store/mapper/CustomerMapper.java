package com.nuri.etk.store.mapper;

import com.nuri.etk.entity.API.MeterSerial;
import com.nuri.etk.store.jpo.CustomerJpo;
import com.nuri.etk.store.jpo.MeterSerialJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerJpo getCustomerByNo(String customerNo) throws Exception;
    MeterSerialJpo getCustomerByMeter(String customerNo) throws Exception;
}