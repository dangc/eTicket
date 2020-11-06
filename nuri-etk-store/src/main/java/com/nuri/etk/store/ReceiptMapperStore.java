package com.nuri.etk.store;

import com.nuri.etk.entity.pojo.CustomerInfo;
import com.nuri.etk.entity.pojo.PaymentInfo;
import com.nuri.etk.store.jpo.CustomerInfoJpo;
import com.nuri.etk.store.jpo.PaymentInfoJpo;
import com.nuri.etk.store.mapper.ReceiptMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReceiptMapperStore implements ReceiptStore {

    private final ReceiptMapper receiptMapper;

    public ReceiptMapperStore(ReceiptMapper receiptMapper) {
        this.receiptMapper = receiptMapper;
    }

    @Override
    public List<CustomerInfo> getReceiptInfo_customerInfo(String meterId, String chargeId) {
        List<CustomerInfoJpo> customerInfoJpos = null;
        try {
            customerInfoJpos = receiptMapper.getReceiptInfo_customerInfo(meterId, chargeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerInfoJpos.stream().map(CustomerInfoJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<PaymentInfo> getReceiptInfo_paymentInfo(String meterId, String chargeId) {
        List<PaymentInfoJpo> paymentInfoJpos = null;
        try {
            paymentInfoJpos = receiptMapper.getReceiptInfo_paymentInfo(meterId, chargeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentInfoJpos.stream().map(PaymentInfoJpo::toDomain).collect(Collectors.toList());
    }
}
