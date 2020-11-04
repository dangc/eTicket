package com.nuri.etk.logic;

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

}
