package com.nuri.etk.logic;

import com.nuri.etk.entity.API.Debt;
import com.nuri.etk.spec.DebtService;
import com.nuri.etk.store.DebtStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DebtLogic implements DebtService {

    private final DebtStore debtStore;

    public DebtLogic(DebtStore debtStore) {
        this.debtStore = debtStore;
    }

    @Override
    public Debt getDebtInfo(String customerNo) {
        Debt debt = new Debt();
        debt.setDept(debtStore.getDebtInfo(customerNo));
        // To do : code값 validation 추가
        debt.setCode(200);
        return debt;
    }
}
