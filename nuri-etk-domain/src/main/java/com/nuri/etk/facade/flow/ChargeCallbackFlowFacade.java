package com.nuri.etk.facade.flow;

import com.nuri.etk.entity.API.ChargeCallback;
import org.springframework.http.HttpHeaders;

public interface ChargeCallbackFlowFacade {
    ChargeCallback meterChargeResult(HttpHeaders headers, ChargeCallback chargeCallback);
}
