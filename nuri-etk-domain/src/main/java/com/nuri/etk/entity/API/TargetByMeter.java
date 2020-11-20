package com.nuri.etk.entity.API;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TargetByMeter {

    private Integer code;
    private String geocode;
    private String address;
    private String lastChargeDate;
    private String customerId;
    private String customerName;
    private String mobileNumber;
    private String supplyState;
    private Double credit;
    private Double arrears;
    private Double debtTotal;

    public TargetByMeter(Integer code, String geocode, Double credit, String address, String lastChargeDate, String customerId, String customerName, String mobileNumber, String supplyState, Double arrears, Double debtTotal) {
        this.code = code;
        this.geocode = geocode;
        this.credit = credit;
        this.address = address;
        this.lastChargeDate = lastChargeDate;
        this.customerId = customerId;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.supplyState = supplyState;
        this.arrears = arrears;
        this.debtTotal = debtTotal;
    }

    public TargetByMeter(TargetByMeter targetByMeter) {
        if(targetByMeter != null){
            this.code = targetByMeter.getCode();
            this.geocode = targetByMeter.getGeocode();
            this.credit = targetByMeter.getCredit();
            this.address = targetByMeter.getAddress();
            this.lastChargeDate = targetByMeter.getLastChargeDate();
            this.customerId = targetByMeter.getCustomerId();
            this.customerName = targetByMeter.getCustomerName();
            this.mobileNumber = targetByMeter.getMobileNumber();
            this.supplyState = targetByMeter.getSupplyState();
            this.arrears = targetByMeter.getArrears();
            this.debtTotal = targetByMeter.getDebtTotal();
        }
    }

    @Override
    public String toString() {
        return "TargetByMeter{" +
                "code=" + code +
                ", geocode='" + geocode + '\'' +
                ", address='" + address + '\'' +
                ", lastChargeDate='" + lastChargeDate + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", supplyState='" + supplyState + '\'' +
                ", credit=" + credit +
                ", arrears=" + arrears +
                ", debtTotal=" + debtTotal +
                '}';
    }
}
