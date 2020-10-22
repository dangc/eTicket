package com.nuri.etk.logic;

import com.nuri.etk.entity.API.Meter;
import com.nuri.etk.spec.MeterService;
import com.nuri.etk.store.MeterStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MeterLogic implements MeterService {

    private final MeterStore meterStore;

    public MeterLogic(MeterStore meterStore) {
        this.meterStore = meterStore;
    }

    @Override
    public List<Meter> getMeterInfo(String meterId){
        return this.meterStore.getMeterInfo(meterId);
    }
}
