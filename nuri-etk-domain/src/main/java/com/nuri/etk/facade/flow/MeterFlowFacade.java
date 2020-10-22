package com.nuri.etk.facade.flow;

import com.nuri.etk.entity.API.Meter;
import com.nuri.etk.entity.API.RegisterInfoByMeter;
import com.nuri.etk.entity.API.TargetByMeter;

import java.util.List;

public interface MeterFlowFacade {
    List<Meter> getMeterInfo(String meterId);
    Meter getMeterList(String customerNo);
    Meter getMeterByGC(String supplier, String geocode);
    TargetByMeter getTargetByMeter(String meterId);
    RegisterInfoByMeter getRegisterInfoByMeter(String meterId);
}
