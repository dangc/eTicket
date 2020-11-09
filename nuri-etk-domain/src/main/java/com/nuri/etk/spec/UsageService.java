package com.nuri.etk.spec;

import com.nuri.etk.entity.API.Usage;
import com.nuri.etk.entity.API.UsageBalance;
import com.nuri.etk.entity.API.UsageMonthly;
import com.nuri.etk.entity.API.UsageYearly;

public interface UsageService {
    UsageBalance getBalance(String meterId);
    Usage getUsage(String meterId);
    UsageMonthly getUsageMonthly(String meterId);
    UsageYearly getUsageYearly(String meterId, String startDate, String endDate);
}
