package com.nuri.etk.spec;

import com.nuri.etk.entity.API.ChargeLastHistory;

public interface ChargeHistoryService {
    ChargeLastHistory chargeLast(String meterId);
}
