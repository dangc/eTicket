package com.nuri.etk.logic;

import com.nuri.etk.spec.ReceiptService;
import com.nuri.etk.store.ReceiptStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReceiptLogic implements ReceiptService {

    private final ReceiptStore receiptStore;

    public ReceiptLogic(ReceiptStore receiptStore) {
        this.receiptStore = receiptStore;
    }

}
