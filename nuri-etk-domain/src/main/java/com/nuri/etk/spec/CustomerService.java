package com.nuri.etk.spec;

import com.nuri.etk.entity.API.Customer;
import com.nuri.etk.entity.API.MeterSerial;


public interface CustomerService {
    Customer getCustomerByNo(String customerNo);
    MeterSerial getCustomerByMeter(String customerNo);
}
