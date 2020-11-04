package com.nuri.etk.store;

import com.nuri.etk.store.mapper.ChargeHistoryMapper;
import org.springframework.stereotype.Component;

@Component
public class ChargeHistoryMapperStore implements ChargeHistoryStore {

    private final ChargeHistoryMapper chargeHistoryMapper;

    public ChargeHistoryMapperStore(ChargeHistoryMapper chargeHistoryMapper) {
        this.chargeHistoryMapper = chargeHistoryMapper;
    }

}
