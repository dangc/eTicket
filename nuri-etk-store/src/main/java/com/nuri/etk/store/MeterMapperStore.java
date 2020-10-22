package com.nuri.etk.store;

import com.nuri.etk.entity.API.Dcu;
import com.nuri.etk.entity.API.Meter;
import com.nuri.etk.store.jpo.DcuJpo;
import com.nuri.etk.store.jpo.MeterJpo;
import com.nuri.etk.store.mapper.DcuMapper;
import com.nuri.etk.store.mapper.MeterMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MeterMapperStore implements MeterStore {

    private final MeterMapper meterMapper;

    public MeterMapperStore(MeterMapper meterMapper) {
        this.meterMapper = meterMapper;
    }

    @Override
    public List<Meter> getMeterInfo(String meterId) {
        List<MeterJpo> meterJpo = null;
        try {
            meterJpo = meterMapper.getMeterInfo(meterId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return meterJpo.stream().map(MeterJpo::toDomain).collect(Collectors.toList());
    }
}
