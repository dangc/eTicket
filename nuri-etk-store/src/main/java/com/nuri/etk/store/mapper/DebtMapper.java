package com.nuri.etk.store.mapper;

import com.nuri.etk.entity.API.Debt;
import com.nuri.etk.store.jpo.DebtInfoJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DebtMapper {
    List<DebtInfoJpo> getDebtInfo(String customerNo);
    Debt getDebtArrears(String customerNo);
}