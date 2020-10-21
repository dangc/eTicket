package com.nuri.etk.facade.flow;

import com.nuri.etk.entity.API.Debt;

public interface DebtFlowFacade {
    Debt getDebtInfo(String customerNo);
}
