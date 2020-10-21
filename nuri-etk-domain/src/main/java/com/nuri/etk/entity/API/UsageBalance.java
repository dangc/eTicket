package com.nuri.etk.entity.API;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UsageBalance {

    private Integer code;
    private String meterId;
    private String date;
    private Double usage;
    private String usageUnit;
    private Double balance;
    private String creditUnit;

    //balance
    public UsageBalance(Integer code, String meterId, String date, Double usage, String usageUnit, Double balance, String creditUnit) {
        this.code = code;
        this.meterId = meterId;
        this.date = date;
        this.usage = usage;
        this.usageUnit = usageUnit;
        this.creditUnit = creditUnit;
        this.balance = balance;
    }

    public static UsageBalance getBalance (String meterId){
        SimpleDateFormat dateFormat = new SimpleDateFormat( "YYYYMMdd");

        UsageBalance usage = new UsageBalance(200, meterId, dateFormat.format(new Date()), 500.0, "kWh", 1200.0, "GHC");

        return usage;
    }
}
