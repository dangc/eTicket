package com.nuri.etk.store;

import com.nuri.etk.entity.pojo.CustomerInfo;
import com.nuri.etk.entity.pojo.PaymentInfo;

import java.util.List;

public interface ReceiptStore {
    List<CustomerInfo> getReceiptInfo_customerInfo(String meterId, String chargeId);
    List<PaymentInfo> getReceiptInfo_paymentInfo(String meterId, String chargeId);
}