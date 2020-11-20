package com.nuri.etk.entity.API;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterInfoByMeter {

    private Integer code;
    private String meterId;
    private String customerName;
    private String mobileNumber;

    public RegisterInfoByMeter(Integer code, String meterId, String customerName, String mobileNumber) {
        this.code = code;
        this.meterId = meterId;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
    }

    public RegisterInfoByMeter(RegisterInfoByMeter registerInfoByMeter) {
        if(registerInfoByMeter != null){
            this.code = registerInfoByMeter.getCode();
            this.meterId = registerInfoByMeter.getMeterId();
            this.customerName = registerInfoByMeter.getCustomerName();
            this.mobileNumber = registerInfoByMeter.getMobileNumber();
        }
    }
}
