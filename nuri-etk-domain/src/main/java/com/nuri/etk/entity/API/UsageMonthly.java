package com.nuri.etk.entity.API;


import com.nuri.etk.entity.pojo.DailyUsages;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
public class UsageMonthly {

    private Integer code;
    private String meterId;
    private List<DailyUsages> dailyUsages;

    public UsageMonthly(Integer code, String meterId, List<DailyUsages> dailyUsages) {
        this.code = code;
        this.meterId = meterId;
        this.dailyUsages = dailyUsages;
    }

    public static UsageMonthly getUsageMonthly(String meterId){
        Random random = new Random();
        SimpleDateFormat startDateFormat = new SimpleDateFormat( "YYYYMM");
        SimpleDateFormat endDateFormat = new SimpleDateFormat( "YYYYMMdd");

        int start = Integer.parseInt(startDateFormat.format(new Date()) + "01");
        int end = Integer.parseInt(endDateFormat.format(new Date()));

        ArrayList<DailyUsages> monthlyUsagesArrayList = new ArrayList<>();

        for(int i= start; start <= end; start++){
            monthlyUsagesArrayList.add(new DailyUsages(Integer.toString(start), Integer.toString(random.nextInt(30)), "kWh", (double)random.nextInt(50), "GHC"));
        }

        UsageMonthly monthly = new UsageMonthly(200, meterId, monthlyUsagesArrayList);

        return monthly;
    }

}
