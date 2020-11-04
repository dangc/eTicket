package com.nuri.etk.logic;

import com.nuri.etk.spec.ChargeService;
import com.nuri.etk.store.ChargeStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChargeLogic implements ChargeService {

    private final ChargeStore chargeStore;

    public ChargeLogic(ChargeStore chargeStore) {
        this.chargeStore = chargeStore;
    }

}
