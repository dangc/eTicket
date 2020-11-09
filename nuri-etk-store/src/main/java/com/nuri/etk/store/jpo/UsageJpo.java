package com.nuri.etk.store.jpo;


import com.nuri.etk.entity.API.Usage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UsageJpo {

    private Integer code;
    private String meterId;             //<METER> MDS_ID
    private String startDate;           //YYYYMMDD
    private String endDate;             //YYYYMMDD
    private Double usage;
    private String usageUnit;
    private Double credit;              //사용금액
    private String creditUnit;          //GHC

    public UsageJpo(Usage usage) {
        if(usage != null){
            this.code = usage.getCode();
            this.meterId = usage.getMeterId();
            this.startDate = usage.getStartDate();
            this.endDate = usage.getEndDate();
            this.usage = usage.getUsage();
            this.usageUnit = usage.getUsageUnit();
            this.credit = usage.getCredit();
            this.creditUnit = usage.getCreditUnit();
        }
    }

    public Usage toDomain() {
        Usage usage = new Usage();
        usage.setCode(this.code);
        usage.setMeterId(this.meterId);
        usage.setStartDate(this.startDate);
        usage.setEndDate(this.endDate);
        usage.setUsage(this.usage);
        usage.setUsageUnit(this.usageUnit);
        usage.setCredit(this.credit);
        usage.setCreditUnit(this.creditUnit);
        return usage;
    }
}
