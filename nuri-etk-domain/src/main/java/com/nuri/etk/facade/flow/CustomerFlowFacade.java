package com.nuri.etk.facade.flow;

import com.nuri.etk.entity.API.ChargeHistory;
import com.nuri.etk.entity.API.MeterSerial;

public interface CustomerFlowFacade {
    ChargeHistory.Customer getCustomerByNo(String customerNo);
    MeterSerial getCustomerByMeter(String meterId);
}
