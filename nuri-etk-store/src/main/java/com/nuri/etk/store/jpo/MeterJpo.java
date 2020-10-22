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

    public MeterJpo(String meterId, String customerId, String customerName, String geocode, String address, String lastChargeDate, String supplyState, Double credit, Double arrears, Double debtTotal) {
        this.meterId = meterId;
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
