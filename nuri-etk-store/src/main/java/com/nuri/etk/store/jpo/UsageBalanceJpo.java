package com.nuri.etk.store.jpo;


import com.nuri.etk.entity.API.UsageBalance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UsageBalanceJpo {

    private Integer code;
    private String meterId;
    private String date;
    private Double usage;
    private String usageUnit;
    private Double balance;
    private String creditUnit;
    private Double oweCredit;

    public UsageBalanceJpo(UsageBalance usageBalance) {
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

    public UsageBalance toDomain() {
        UsageBalance usageBalance = new UsageBalance();
        usageBalance.setCode(this.code);
        usageBalance.setMeterId(this.meterId);
        usageBalance.setDate(this.date);
        usageBalance.setUsage(this.usage);
        usageBalance.setUsageUnit(this.usageUnit);
        usageBalance.setBalance(this.balance);
        usageBalance.setCreditUnit(this.creditUnit);
        usageBalance.setOweCredit(this.oweCredit);
        return usageBalance;
    }
}
