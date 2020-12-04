package com.nuri.etk.store.jpo;


import com.nuri.etk.entity.API.ChargeHistory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerJpo {

    private Integer code;
    private String customerId;
    private String meterModel;
    private String modemId;
    private String geocode;

    public CustomerJpo(ChargeHistory.Customer customer) {
        if(customer != null){
            this.code = customer.getCode();
            this.customerId = customer.getCustomerId();
            this.meterModel = customer.getMeterModel();
            this.modemId = customer.getModemId();
            this.geocode = customer.getGeocode();
        }
    }

    public ChargeHistory.Customer toDomain() {
        ChargeHistory.Customer customer = new ChargeHistory.Customer();
        customer.setCode(this.code);
        customer.setCustomerId(this.customerId);
        customer.setMeterModel(this.meterModel);
        customer.setModemId(this.modemId);
        customer.setGeocode(this.geocode);
        return customer;
    }
}
