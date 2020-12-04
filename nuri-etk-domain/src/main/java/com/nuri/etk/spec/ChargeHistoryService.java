package com.nuri.etk.spec;

import com.nuri.etk.entity.API.ChargeHistory;
import com.nuri.etk.entity.API.ChargeLastHistory;

public interface ChargeHistoryService {
    ChargeLastHistory chargeLast(String meterId);

    ChargeHistory chargeHistory(String meterId, String startDate, String endDate, String paymentType, String listCount, String pageCount);
}
