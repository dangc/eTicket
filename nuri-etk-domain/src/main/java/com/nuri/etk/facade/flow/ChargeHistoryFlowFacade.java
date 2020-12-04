package com.nuri.etk.facade.flow;

import com.nuri.etk.entity.API.ChargeHistory;
import com.nuri.etk.entity.API.ChargeLastHistory;
import org.springframework.http.HttpHeaders;

public interface ChargeHistoryFlowFacade {
    ChargeLastHistory chargeLast(String meterId);
    ChargeHistory chargeHistory(String meterId, HttpHeaders headers) throws Exception;
}
