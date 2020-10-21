package com.nuri.etk.entity.API;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Meter {

    private Integer code;
    private String meterId;
    private String customerId;
    private String customerName;
//    private String meterModel;
//    private String modemId;
    private String geocode;
    private String address;
    private String lastChargeDate;
    private String supplyState;
    private Double credit;
    private Double arrears;
    private Double debtTotal;
//    private List<Meter> data;

    public Meter(Integer code, String meterId) {
        this.code = code;
        this.meterId = meterId;
    }

    public Meter(Integer code, String customerId, String customerName, String geocode, String address, String lastChargeDate,
                 String supplyState, Double credit, Double arrears, Double debtTotal) {
        this.code = code;
        this.customerId = customerId;
        this.customerName = customerName;
        this.geocode = geocode;
        this.address = address;
        this.lastChargeDate = lastChargeDate;
        this.supplyState = supplyState;
        this.credit = credit;
        this.arrears = arrears;
        this.debtTotal = debtTotal;
    }

    public Meter(Integer code, List<Meter> data) {
        this.code = code;
//        this.data = data.toString();
    }

    public static Meter getMeterList(String customerNo){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        List<Meter> meterArrayList = new ArrayList<Meter>();
        meterArrayList.add(new Meter(200,"customer111","ECGCustomer","stsCon_04","7200-PRAMPRAM, St1 - Prampram - PRAMPRAM",dateFormat.format(new Date()),"Normal",150.0,11.0,2.0));

        Meter meter = new Meter(200, meterArrayList);

        return meter;
    }

    public static Meter getMeterByGC(String supplier, String geocode){
        return new Meter(200, "P191035096");
    }


    public static Meter getTargetByMeter(String meterId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        Meter meter = new Meter(200,"3241312","ECGCustomer","03042100301659160","7200-PRAMPRAM, St1 - Prampram - PRAMPRAM",dateFormat.format(new Date()),"Normal",3000.0, 0.0, 20.0);
        meter.setMeterId(meterId);

        return meter;

    }
}
