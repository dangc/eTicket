package com.nuri.etk.store;

import com.nuri.etk.entity.API.ChargeHistory;
import com.nuri.etk.entity.API.MeterSerial;

public interface CustomerStore {
    ChargeHistory.Customer getCustomerByNo(String customerNo);
    MeterSerial getCustomerByMeter(String customerNo);
}