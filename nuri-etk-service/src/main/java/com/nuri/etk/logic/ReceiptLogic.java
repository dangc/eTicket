package com.nuri.etk.logic;

import com.nuri.etk.entity.API.Receipt;
import com.nuri.etk.entity.pojo.CustomerInfo;
import com.nuri.etk.entity.pojo.PaymentInfo;
import com.nuri.etk.spec.ReceiptService;
import com.nuri.etk.store.ReceiptStore;
import com.nuri.etk.store.jpo.CustomerInfoJpo;
import com.nuri.etk.store.jpo.PaymentInfoJpo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReceiptLogic implements ReceiptService {

    private final ReceiptStore receiptStore;

    public ReceiptLogic(ReceiptStore receiptStore) {
        this.receiptStore = receiptStore;
    }

    @Override
    public Receipt getReceiptInfo(String meterId, String chargeId) {
        Receipt receipt = new Receipt();
        receipt.setCustomerInfo(receiptStore.getReceiptInfo_customerInfo(meterId, chargeId));
        receipt.setPaymentInfo(receiptStore.getReceiptInfo_paymentInfo(meterId, chargeId));
        // To do : code값 validation 추가
        receipt.setCode(200);

        return receipt;
    }
}
