package com.nuri.etk.entity.API;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Meter {

    private Integer code;
//    private String meterId;
//    private String customerId;
//    private String customerName;
//    private String meterModel;
//    private String modemId;
//    private String geocode;
//    private String address;
//    private String lastChargeDate;
//    private String supplyState;
//    private Double credit;
//    private Double arrears;
//    private Double debtTotal;
    private List<Meters> data;

    public Meter(Integer code, Meters data) {
        this.code = code;
        this.data = (List<Meters>) data;
    }

    /*public Meter(Integer code, String customerId, String customerName, String geocode, String address, String lastChargeDate,
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
    }*/


    public Meter(Integer code, List<Meter> data) {
        this.code = code;
//        this.data = data.toString();
    }
}
