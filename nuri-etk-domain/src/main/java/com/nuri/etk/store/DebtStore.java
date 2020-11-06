package com.nuri.etk.store;

import com.nuri.etk.entity.API.Debt;
import com.nuri.etk.entity.pojo.DebtInfo;

import java.util.List;


public interface DebtStore {
    List<DebtInfo> getDebtInfo(String customerNo);
    Debt getDebtArrears(String customerNo);
}