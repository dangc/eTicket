package com.nuri.etk.store;

import com.nuri.etk.entity.API.ChargeLastHistory;
import com.nuri.etk.entity.pojo.PaymentInfo;

import java.util.ArrayList;
import java.util.List;

public interface ChargeHistoryStore {
    List<PaymentInfo> chargeLast(String meterId);

    List<PaymentInfo> chargeHistory(String meterId, String startDate, String endDate, String paymentType, String listCount, String pageCount);
}