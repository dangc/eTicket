package com.nuri.etk.store.mapper;

import com.nuri.etk.store.jpo.MeterJpo;
import com.nuri.etk.store.jpo.RegisterInfoByMeterJpo;
import com.nuri.etk.store.jpo.TargetByMeterJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeterMapper {
    List<MeterJpo> getMeterInfo(String meterId) throws Exception;
    TargetByMeterJpo getTargetByMeter(String meterId) throws Exception;
    RegisterInfoByMeterJpo getRegisterInfoByMeter(String meterId) throws Exception;
}