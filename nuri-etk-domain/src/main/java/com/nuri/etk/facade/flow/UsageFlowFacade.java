package com.nuri.etk.facade.flow;

import com.nuri.etk.entity.API.Usage;
import com.nuri.etk.entity.API.UsageBalance;
import com.nuri.etk.entity.API.UsageMonthly;
import com.nuri.etk.entity.API.UsageYearly;

public interface UsageFlowFacade {
    Usage getUsage (String meterId);
    UsageBalance getBalance (String meterId);
    UsageMonthly getUsageMonthly (String meterId);
    UsageYearly getUsageYearly (String meterId, String startDate, String endDate);
}
