package com.nuri.etk.store;

import com.nuri.etk.entity.API.Customer;
import com.nuri.etk.entity.API.Meter;
import com.nuri.etk.entity.API.MeterSerial;

import java.util.List;

public interface CustomerStore {
    Customer getCustomerByNo(String customerNo);
    MeterSerial getCustomerByMeter(String customerNo);
}