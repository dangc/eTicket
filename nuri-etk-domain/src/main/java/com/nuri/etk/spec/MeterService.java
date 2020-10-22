package com.nuri.etk.spec;

import com.nuri.etk.entity.API.Dcu;
import com.nuri.etk.entity.API.Meter;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface MeterService {

    List<Meter> getMeterInfo(String meterId);
}
