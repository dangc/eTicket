package com.nuri.etk.spec;

import com.nuri.etk.entity.API.Charge;
import com.nuri.etk.entity.pojo.ChargeInfo;
import org.springframework.http.HttpHeaders;

public interface ChargeService {
    public Charge meterCharge(String meterId, HttpHeaders headers, ChargeInfo chargeInfo);
}
