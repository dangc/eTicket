package com.nuri.etk.spec;

import com.nuri.etk.entity.API.ChargeHistory;
import com.nuri.etk.entity.API.MeterSerial;


public interface CustomerService {
    ChargeHistory.Customer getCustomerByNo(String customerNo);
    MeterSerial getCustomerByMeter(String customerNo);
}
