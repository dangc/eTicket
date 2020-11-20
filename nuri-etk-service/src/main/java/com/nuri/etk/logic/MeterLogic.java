package com.nuri.etk.logic;

import com.nuri.etk.entity.API.Meter;
import com.nuri.etk.entity.API.RegisterInfoByMeter;
import com.nuri.etk.entity.API.TargetByMeter;
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
        return meterStore.getMeterInfo(meterId);
    }

    @Override
    public TargetByMeter getTargetByMeter(String meterId) {
        TargetByMeter targetByMeter = new TargetByMeter(meterStore.getTargetByMeter(meterId));
        if(targetByMeter != null){
            targetByMeter.setCode(200);
        }
        return targetByMeter;
    }

    @Override
    public RegisterInfoByMeter getRegisterInfoByMeter(String meterId) {
        return meterStore.getRegisterInfoByMeter(meterId);
    }
}
