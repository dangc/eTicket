package com.nuri.etk.store;

import com.nuri.etk.entity.API.Usage;
import com.nuri.etk.entity.API.UsageBalance;
import com.nuri.etk.entity.API.UsageMonthly;
import com.nuri.etk.entity.API.UsageYearly;
import com.nuri.etk.entity.pojo.DailyUsages;
import com.nuri.etk.entity.pojo.MonthlyUsages;

import java.util.List;

public interface UsageStore {
    UsageBalance getBalance(String meterId);
    Usage getUsage(String meterId);
    List<DailyUsages> getUsageMonthly(String meterId);
    List<MonthlyUsages> getUsageYearly(String meterId, String startDate, String endDate);
}