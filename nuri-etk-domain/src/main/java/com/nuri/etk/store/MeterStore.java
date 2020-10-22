package com.nuri.etk.store;

import com.nuri.etk.entity.API.Meter;

import java.util.List;

public interface MeterStore {

    List<Meter> getMeterInfo(String meterId);
}