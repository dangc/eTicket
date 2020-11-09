package com.nuri.etk.store;

import com.nuri.etk.entity.API.Usage;
import com.nuri.etk.entity.API.UsageBalance;
import com.nuri.etk.entity.pojo.DailyUsages;
import com.nuri.etk.entity.pojo.MonthlyUsages;
import com.nuri.etk.store.jpo.DailyUsagesJpo;
import com.nuri.etk.store.jpo.MonthlyUsagesJpo;
import com.nuri.etk.store.jpo.UsageBalanceJpo;
import com.nuri.etk.store.jpo.UsageJpo;
import com.nuri.etk.store.mapper.UsageMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsageMapperStore implements UsageStore {

    private final UsageMapper usageMapper;

    public UsageMapperStore(UsageMapper usageMapper) {
        this.usageMapper = usageMapper;
    }

    @Override
    public UsageBalance getBalance(String meterId) {
        UsageBalanceJpo usageBalanceJpo = null;
        try {
            usageBalanceJpo = usageMapper.getBalance(meterId);
        } catch (Exception e){
            e.printStackTrace();
        }
        return usageBalanceJpo.toDomain();
    }

    @Override
    public Usage getUsage(String meterId) {
        UsageJpo usageJpo = null;
        try {
            usageJpo = usageMapper.getUsage(meterId);
        } catch (Exception e){
            e.printStackTrace();
        }
        return usageJpo.toDomain();
    }

    @Override
    public List<DailyUsages> getUsageMonthly(String meterId) {
        List<DailyUsagesJpo> dailyUsagesJpos = null;
        try {
            dailyUsagesJpos = usageMapper.getUsageMonthly(meterId);
        } catch (Exception e){
            e.printStackTrace();
        }
        return dailyUsagesJpos.stream().map(DailyUsagesJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<MonthlyUsages> getUsageYearly(String meterId, String startDate, String endDate) {
        List<MonthlyUsagesJpo> monthlyUsagesJpos = null;
        try {
            monthlyUsagesJpos = usageMapper.getUsageYearly(meterId, startDate, endDate);
        } catch (Exception e){
            e.printStackTrace();
        }
        return monthlyUsagesJpos.stream().map(MonthlyUsagesJpo::toDomain).collect(Collectors.toList());
    }
}
