package com.nuri.etk.logic;

import com.nuri.etk.entity.API.Usage;
import com.nuri.etk.entity.API.UsageBalance;
import com.nuri.etk.entity.API.UsageMonthly;
import com.nuri.etk.entity.API.UsageYearly;
import com.nuri.etk.spec.UsageService;
import com.nuri.etk.store.UsageStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsageLogic implements UsageService {

    private final UsageStore usageStore;

    public UsageLogic(UsageStore usageStore) {
        this.usageStore = usageStore;
    }

    @Override
    public UsageBalance getBalance(String meterId) {
        UsageBalance usageBalance = new UsageBalance(usageStore.getBalance(meterId));
        if(usageBalance != null){
            usageBalance.setCode(200);
        }
        return usageBalance;
    }

    @Override
    public Usage getUsage(String meterId) {
        Usage usage = new Usage(usageStore.getUsage(meterId));
        if(usage != null){
            usage.setCode(200);
        }
        return usage;
    }

    @Override
    public UsageMonthly getUsageMonthly(String meterId) {
        UsageMonthly usageMonthly = new UsageMonthly();
//        usageMonthly.setMeterId(usageStore.);
        usageMonthly.setDailyUsages(usageStore.getUsageMonthly(meterId));
        // To do : code값 validation 추가
        usageMonthly.setCode(200);
        return usageMonthly;
    }

    @Override
    public UsageYearly getUsageYearly(String meterId, String startDate, String endDate) {
        UsageYearly usageYearly = new UsageYearly();
//        usageYearly.setMeterId();
        usageYearly.setMonthlyUsages(usageStore.getUsageYearly(meterId, startDate, endDate));
        // To do : code값 validation 추가
        usageYearly.setCode(200);
        return usageYearly;
    }
}
