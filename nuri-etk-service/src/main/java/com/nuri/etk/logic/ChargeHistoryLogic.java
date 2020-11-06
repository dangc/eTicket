package com.nuri.etk.logic;

import com.nuri.etk.entity.API.ChargeLastHistory;
import com.nuri.etk.spec.ChargeHistoryService;
import com.nuri.etk.store.ChargeHistoryStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChargeHistoryLogic implements ChargeHistoryService {

    private final ChargeHistoryStore chargeHistoryStore;

    public ChargeHistoryLogic(ChargeHistoryStore chargeHistoryStore) {
        this.chargeHistoryStore = chargeHistoryStore;
    }

    @Override
    public ChargeLastHistory chargeLast(String meterId) {
        ChargeLastHistory chargeLastHistory = new ChargeLastHistory();
        chargeLastHistory.setPaymentInfo(chargeHistoryStore.chargeLast(meterId));
        // To do : code값 validation 추가
        chargeLastHistory.setCode(200);

        return chargeLastHistory;
    }
}
