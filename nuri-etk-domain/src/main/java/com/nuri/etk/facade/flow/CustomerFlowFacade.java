package com.nuri.etk.facade.flow;

import com.nuri.etk.entity.API.Customer;
import com.nuri.etk.entity.API.MeterSerial;

public interface CustomerFlowFacade {
    Customer getCustomerByNo(String customerNo);
    MeterSerial getCustomerByMeter(String meterId);
}
