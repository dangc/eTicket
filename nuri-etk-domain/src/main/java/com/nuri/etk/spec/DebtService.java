package com.nuri.etk.spec;

import com.nuri.etk.entity.API.Debt;

public interface DebtService {
    Debt getDebtInfo(String customerNo);
}
