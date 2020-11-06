package com.nuri.etk.store.jpo;

import com.nuri.etk.entity.API.Dcu;
import com.nuri.etk.entity.API.Meter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MeterJpo {

    private String meterId;
    private String customerId;
    private String customerName;
    private String geocode;
    private String address;
    private String lastChargeDate;
    private String supplyState;
    private Double credit;
    private Double arrears;
    private Double debtTotal;

    public MeterJpo(Meter meter) {
        if(meter != null) {
            this.meterId = meter.getMeterId();
            this.customerId = meter.getCustomerId();
            this.customerName = meter.getCustomerName();
            this.geocode = meter.getGeocode();
            this.address = meter.getAddress();
            this.lastChargeDate = meter.getLastChargeDate();
            this.supplyState = meter.getSupplyState();
            this.credit = meter.getCredit();
            this.arrears = meter.getArrears();
            this.debtTotal = meter.getDebtTotal();
        }
    }

    public Meter toDomain() {
        Meter meter = new Meter();
        meter.setMeterId(this.meterId);
        meter.setCustomerId(this.customerId);
        meter.setCustomerName(this.customerName);
        meter.setGeocode(this.geocode);
        meter.setAddress(this.address);
        meter.setLastChargeDate(this.lastChargeDate);
        meter.setSupplyState(this.supplyState);
        meter.setCredit(this.credit);
        meter.setArrears(this.arrears);
        meter.setDebtTotal(this.debtTotal);
        return meter;
    }
}
