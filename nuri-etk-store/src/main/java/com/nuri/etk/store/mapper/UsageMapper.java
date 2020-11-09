package com.nuri.etk.store.mapper;

import com.nuri.etk.store.jpo.DailyUsagesJpo;
import com.nuri.etk.store.jpo.MonthlyUsagesJpo;
import com.nuri.etk.store.jpo.UsageBalanceJpo;
import com.nuri.etk.store.jpo.UsageJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsageMapper {
    UsageBalanceJpo getBalance(String meterId) throws Exception;
    UsageJpo getUsage(String meterId) throws Exception;
    List<DailyUsagesJpo> getUsageMonthly(String meterId) throws Exception;
    List<MonthlyUsagesJpo> getUsageYearly(String meterId, String startDate, String endDate) throws Exception;
}