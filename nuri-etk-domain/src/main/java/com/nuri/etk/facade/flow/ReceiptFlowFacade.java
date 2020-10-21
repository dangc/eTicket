package com.nuri.etk.facade.flow;

import com.nuri.etk.entity.API.Receipt;

public interface ReceiptFlowFacade {
    Receipt getReceiptInfo(String meterId, String chargeId);
}
