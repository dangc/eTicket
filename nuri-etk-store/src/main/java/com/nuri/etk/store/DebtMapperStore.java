package com.nuri.etk.store;

import com.nuri.etk.store.mapper.ChargeMapper;
import com.nuri.etk.store.mapper.DebtMapper;
import org.springframework.stereotype.Component;

@Component
public class DebtMapperStore implements DebtStore {

    private final DebtMapper debtMapper;

    public DebtMapperStore(DebtMapper debtMapper) {
        this.debtMapper = debtMapper;
    }

}
