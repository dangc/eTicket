package com.nuri.etk.entity.API;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer {

//    private String meterId;
    private Integer code;
    private String customerId;
    private String meterModel;
    private String modemId;
    private String geocode;

    public Customer(Integer code, String customerId, String meterModel, String modemId, String geocode) {
        this.code = code;
        this.customerId = customerId;
        this.meterModel = meterModel;
        this.modemId = modemId;
        this.geocode = geocode;
    }
    public Customer(Customer customer) {
        if(customer != null){
            this.code = customer.getCode();
            this.customerId = customer.getCustomerId();
            this.meterModel = customer.getMeterModel();
            this.modemId = customer.getModemId();
            this.geocode = customer.getGeocode();
        }
    }
}
