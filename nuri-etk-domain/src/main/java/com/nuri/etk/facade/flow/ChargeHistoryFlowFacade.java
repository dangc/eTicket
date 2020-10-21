package com.nuri.etk.facade.flow;

import com.nuri.etk.entity.API.ChargeHistory;
import com.nuri.etk.entity.API.ChargeLastHistory;

public interface ChargeHistoryFlowFacade {
    ChargeLastHistory chargeLast(String meterId);
    ChargeHistory chargeHistory(String meterId, String startDate, String endDate, String paymentType, String listCount, String pageCount) throws Exception;
}
