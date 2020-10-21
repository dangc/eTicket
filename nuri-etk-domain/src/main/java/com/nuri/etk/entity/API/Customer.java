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

    public static Customer getCustomerByNo(String customerNo) {
        Customer customer = new Customer(200, customerNo, "NRAM-3405CT10", "000B1200000D1506", "03042100301754850");
//        customer.setMeterId(meterId);

        return customer;
    }

    public static Customer getCustomerByMeter(String customerNo) {
        Customer customer = new Customer(200, customerNo, "NRAM-3405CT10", "000B12000010D86F", "03042100320101500");
//        customer.setMeterId("23234234");

        return customer;
    }
}
