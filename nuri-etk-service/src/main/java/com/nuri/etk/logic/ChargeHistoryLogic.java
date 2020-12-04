package com.nuri.etk.logic;

import com.nuri.etk.entity.API.ChargeHistory;
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
        if(chargeLastHistory != null){
            chargeLastHistory.setCode(200);
        }
        return chargeLastHistory;
    }

    @Override
    public ChargeHistory chargeHistory(String meterId, String startDate, String endDate, String paymentType, String listCount, String pageCount) {
        ChargeHistory chargeHistory = new ChargeHistory();
        chargeHistory.setTotalCount(chargeHistoryStore.chargeHistory(meterId, startDate, endDate, paymentType, null, null).size());
        chargeHistory.setChargeLogs(chargeHistoryStore.chargeHistory(meterId, startDate, endDate, paymentType, listCount, pageCount));

        if(chargeHistory.getChargeLogs() != null){
            chargeHistory.setCode(200);
        }
        return chargeHistory;
    }
}
