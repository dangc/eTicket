package com.nuri.etk.store;

import com.nuri.etk.entity.API.Meter;
import com.nuri.etk.entity.API.Meters;
import com.nuri.etk.entity.API.RegisterInfoByMeter;
import com.nuri.etk.entity.API.TargetByMeter;

import java.util.List;

public interface MeterStore {
    List<Meters> getMeterInfo(String meterId);
    TargetByMeter getTargetByMeter(String meterId);
    RegisterInfoByMeter getRegisterInfoByMeter(String meterId);
}