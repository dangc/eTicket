package com.nuri.etk.entity.API;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Usage {

    private Integer code;
    private String meterId;             //<METER> MDS_ID
    private String startDate;           //YYYYMMDD
    private String endDate;             //YYYYMMDD
    private Double usage;
    private String usageUnit;
    private Double credit;              //사용금액
    private String creditUnit;          //GHC

    public Usage(Usage usage) {
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
}
