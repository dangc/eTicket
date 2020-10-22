package com.nuri.etk.store.mapper;

import com.nuri.etk.entity.API.Meter;
import com.nuri.etk.store.jpo.DcuJpo;
import com.nuri.etk.store.jpo.MeterJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeterMapper {
    List<MeterJpo> getMeterInfo(String meterId) throws Exception;
}