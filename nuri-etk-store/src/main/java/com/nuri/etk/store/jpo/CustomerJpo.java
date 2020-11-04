package com.nuri.etk.store.jpo;


import com.nuri.etk.entity.API.Customer;
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

    public CustomerJpo(Integer code, String customerId, String meterModel, String modemId, String geocode) {
        this.code = code;
        this.customerId = customerId;
        this.meterModel = meterModel;
        this.modemId = modemId;
        this.geocode = geocode;
    }

    public Customer toDomain() {
        Customer customer = new Customer();
        customer.setCode(this.code);
        customer.setCustomerId(this.customerId);
        customer.setMeterModel(this.meterModel);
        customer.setModemId(this.modemId);
        customer.setGeocode(this.geocode);
        return customer;
    }
}
