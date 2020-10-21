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

    //usage
    public Usage(Integer code, String meterId, String startDate, String endDate, Double usage, String usageUnit, Double credit, String creditUnit) {
        this.code = code;
        this.meterId = meterId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.usage = usage;
        this.usageUnit = usageUnit;
        this.credit = credit;
        this.creditUnit = creditUnit;
    }

    public static Usage getUsage(String meterId){
        SimpleDateFormat startDateFormat = new SimpleDateFormat( "YYYYMM");
        SimpleDateFormat endDateFormat = new SimpleDateFormat( "YYYYMMdd");

        Usage usage = new Usage(200, meterId, "", "", 500.0, "kWh", 1200.0, "GHC");
        usage.setStartDate(startDateFormat.format(new Date()) + "01");      //사용 시작일(yyyyMMdd): 매월 1일
        usage.setEndDate(endDateFormat.format(new Date()));                 //사용 마지막일(yyyyMMdd): 현재 날짜

        return usage;
    }
}
