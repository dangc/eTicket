package com.nuri.etk.store;

import com.nuri.etk.entity.API.ChargeLastHistory;
import com.nuri.etk.entity.pojo.PaymentInfo;
import com.nuri.etk.store.jpo.PaymentInfoJpo;
import com.nuri.etk.store.mapper.ChargeHistoryMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChargeHistoryMapperStore implements ChargeHistoryStore {

    private final ChargeHistoryMapper chargeHistoryMapper;

    public ChargeHistoryMapperStore(ChargeHistoryMapper chargeHistoryMapper) {
        this.chargeHistoryMapper = chargeHistoryMapper;
    }

    @Override
    public List<PaymentInfo> chargeLast(String meterId) {
        List<PaymentInfoJpo> chargeLastHistories = null;
        try {
            chargeLastHistories = chargeHistoryMapper.chargeLast(meterId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chargeLastHistories.stream().map(PaymentInfoJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<PaymentInfo> chargeHistory(String meterId, String startDate, String endDate, String paymentType, String listCount, String pageCount) {
        List<PaymentInfoJpo> chargeHistories = null;
        try {
            chargeHistories = chargeHistoryMapper.chargeHistory(meterId, startDate, endDate, paymentType, listCount, pageCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chargeHistories.stream().map(PaymentInfoJpo::toDomain).collect(Collectors.toList());
    }
}
