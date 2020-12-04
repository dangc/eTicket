package com.nuri.etk.store.jpo;


import com.nuri.etk.entity.API.TargetByMeter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TargetByMeterJpo {

    private Integer code;
    private String geocode;
    private Double credit;
    private Double oweCredit;
    private String address;
    private String lastChargeDate;
    private String customerId;
    private String customerName;
    private String mobileNumber;
    private String supplyState;
    private Double arrears;
    private Double debtTotal;

    public TargetByMeterJpo(TargetByMeter targetByMeter) {
        if(targetByMeter != null){
            this.code = targetByMeter.getCode();
            this.geocode = targetByMeter.getGeocode();
            this.credit = targetByMeter.getCredit();
            this.oweCredit = targetByMeter.getOweCredit();
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

    public TargetByMeter toDomain(){
        TargetByMeter targetByMeter = new TargetByMeter();
        targetByMeter.setCode(this.code);
        targetByMeter.setGeocode(this.geocode);
        targetByMeter.setCredit(this.credit);
        targetByMeter.setOweCredit(this.oweCredit);
        targetByMeter.setAddress(this.address);
        targetByMeter.setLastChargeDate(this.lastChargeDate);
        targetByMeter.setCustomerId(this.customerId);
        targetByMeter.setCustomerName(this.customerName);
        targetByMeter.setMobileNumber(this.mobileNumber);
        targetByMeter.setSupplyState(this.supplyState);
        targetByMeter.setArrears(this.arrears);
        targetByMeter.setDebtTotal(this.debtTotal);
        return targetByMeter;
    }
}
