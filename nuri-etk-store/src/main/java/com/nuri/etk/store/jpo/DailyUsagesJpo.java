package com.nuri.etk.store.jpo;


import com.nuri.etk.entity.pojo.DailyUsages;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DailyUsagesJpo {

    private String date;
    private String usage;
    private String usageUnit;
    private Double credit;
    private String creditUnit;

    public DailyUsagesJpo(DailyUsages dailyUsages) {
        if(dailyUsages != null){
            this.date = dailyUsages.getDate();
            this.usage = dailyUsages.getUsage();
            this.usageUnit = dailyUsages.getUsageUnit();
            this.credit = dailyUsages.getCredit();
            this.creditUnit = dailyUsages.getCreditUnit();
        }
    }

    public DailyUsages toDomain(){
        DailyUsages dailyUsages = new DailyUsages();
        dailyUsages.setDate(this.date);
        dailyUsages.setUsage(this.usage);
        dailyUsages.setUsageUnit(this.usageUnit);
        dailyUsages.setCredit(this.credit);
        dailyUsages.setCreditUnit(this.creditUnit);
        return dailyUsages;
    }
}
