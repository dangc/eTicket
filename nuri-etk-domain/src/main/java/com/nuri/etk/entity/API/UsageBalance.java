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
    private Double oweCredit;

    public UsageBalance(UsageBalance usageBalance) {
        if(usageBalance != null){
            this.code = usageBalance.getCode();
            this.meterId = usageBalance.getMeterId();
            this.date = usageBalance.getDate();
            this.usage = usageBalance.getUsage();
            this.usageUnit = usageBalance.getUsageUnit();
            this.creditUnit = usageBalance.getCreditUnit();
            this.balance = usageBalance.getBalance();
            this.oweCredit = usageBalance.getOweCredit();
        }
    }
}
