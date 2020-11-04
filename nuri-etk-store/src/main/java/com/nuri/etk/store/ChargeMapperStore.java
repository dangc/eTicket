package com.nuri.etk.store;

import com.nuri.etk.store.mapper.ChargeMapper;
import org.springframework.stereotype.Component;

@Component
public class ChargeMapperStore implements ChargeStore {

    private final ChargeMapper chargeMapper;

    public ChargeMapperStore(ChargeMapper chargeMapper) {
        this.chargeMapper = chargeMapper;
    }

}
