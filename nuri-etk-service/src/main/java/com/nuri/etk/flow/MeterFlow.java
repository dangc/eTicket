package com.nuri.etk.flow;

import com.nuri.etk.entity.API.Dcu;
import com.nuri.etk.entity.API.Meter;
import com.nuri.etk.entity.API.RegisterInfoByMeter;
import com.nuri.etk.entity.API.TargetByMeter;
import com.nuri.etk.facade.flow.DcuFlowFacade;
import com.nuri.etk.facade.flow.MeterFlowFacade;
import com.nuri.etk.spec.MeterService;
import com.nuri.etk.spec.SampleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MeterFlow implements MeterFlowFacade {

    private MeterService meterService;

    public MeterFlow(MeterService meterService) {
        this.meterService = meterService;
    }

    @Override
    public List<Meter> getMeterInfo(String meterId) {
        return meterService.getMeterInfo(meterId);
    }

    @Override
    public Meter getMeterList(String customerNo) {
        return null;
    }

    @Override
    public Meter getMeterByGC(String supplier, String geocode) {
        return null;
    }

    @Override
    public TargetByMeter getTargetByMeter(String meterId) {
        return null;
    }

    @Override
    public RegisterInfoByMeter getRegisterInfoByMeter(String meterId) {
        return null;
    }
}