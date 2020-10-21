package com.nuri.etk.facade.flow;

import com.nuri.etk.entity.API.Charge;
import com.nuri.etk.entity.pojo.ChargeCancelInfo;
import com.nuri.etk.entity.pojo.ChargeInfo;

import org.springframework.http.HttpHeaders;

public interface ChargeFlowFacade {
//    Charge meterCharge(String meterId, boolean async, String callbackUrl, HttpHeaders headers, ChargeInfo chargeInfo) throws Exception;
    Charge meterCharge(String meterId, boolean async, HttpHeaders headers, ChargeInfo chargeInfo) throws Exception;
    Charge meterChargeCancle(String meterId, boolean async, HttpHeaders headers, ChargeCancelInfo chargeCancelInfo);
}
