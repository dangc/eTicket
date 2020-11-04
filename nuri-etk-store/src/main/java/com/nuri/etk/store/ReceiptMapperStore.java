package com.nuri.etk.store;

import com.nuri.etk.store.mapper.DebtMapper;
import com.nuri.etk.store.mapper.ReceiptMapper;
import org.springframework.stereotype.Component;

@Component
public class ReceiptMapperStore implements ReceiptStore {

    private final ReceiptMapper receiptMapper;

    public ReceiptMapperStore(ReceiptMapper receiptMapper) {
        this.receiptMapper = receiptMapper;
    }

}
