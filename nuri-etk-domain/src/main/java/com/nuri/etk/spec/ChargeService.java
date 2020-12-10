package com.nuri.etk.spec;

import com.nuri.etk.entity.API.Charge;
import com.nuri.etk.entity.pojo.ChargeCancelInfo;
import com.nuri.etk.entity.pojo.ChargeInfo;
import org.springframework.http.HttpHeaders;

public interface ChargeService {
    Charge meterCharge(String meterId, HttpHeaders headers, ChargeInfo chargeInfo) throws Exception;

    Charge meterChargeCancle(String meterId, HttpHeaders headers, ChargeCancelInfo chargeCancelInfo) throws Exception;
}
