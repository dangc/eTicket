package com.nuri.etk.store.jpo;


import com.nuri.etk.entity.pojo.MonthlyUsages;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MonthlyUsagesJpo {

    private String responseDateTime;
    private String usage;
    private String usageUnit;
    private Double credit;
    private String creditUnit;

    public MonthlyUsagesJpo(MonthlyUsages monthlyUsages) {
        if(monthlyUsages != null){
            this.responseDateTime = monthlyUsages.getResponseDateTime();
            this.usage = monthlyUsages.getUsage();
            this.usageUnit = monthlyUsages.getUsageUnit();
            this.credit = monthlyUsages.getCredit();
            this.creditUnit = monthlyUsages.getCreditUnit();
        }
    }

    public MonthlyUsages toDomain(){
        MonthlyUsages monthlyUsages = new MonthlyUsages();
        monthlyUsages.setResponseDateTime(this.responseDateTime);
        monthlyUsages.setUsage(this.usage);
        monthlyUsages.setUsageUnit(this.usageUnit);
        monthlyUsages.setCredit(this.credit);
        monthlyUsages.setCreditUnit(this.creditUnit);
        return monthlyUsages;
    }
}
