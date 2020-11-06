package com.nuri.etk.store;

import com.nuri.etk.entity.API.Debt;
import com.nuri.etk.entity.pojo.DebtInfo;
import com.nuri.etk.store.jpo.DebtInfoJpo;
import com.nuri.etk.store.mapper.DebtMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DebtMapperStore implements DebtStore {

    private final DebtMapper debtMapper;

    public DebtMapperStore(DebtMapper debtMapper) {
        this.debtMapper = debtMapper;
    }

    @Override
    public List<DebtInfo> getDebtInfo(String customerNo) {
        List<DebtInfoJpo> debtInfoJpos = null;
        try {
            debtInfoJpos = debtMapper.getDebtInfo(customerNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return debtInfoJpos.stream().map(DebtInfoJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public Debt getDebtArrears(String customerNo) {
        return null;
    }
}
