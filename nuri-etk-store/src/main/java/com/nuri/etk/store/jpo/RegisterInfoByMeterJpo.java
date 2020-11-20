package com.nuri.etk.store.jpo;


import com.nuri.etk.entity.API.RegisterInfoByMeter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterInfoByMeterJpo {

    private Integer code;
    private String meterId;
    private String customerName;
    private String mobileNumber;

    public RegisterInfoByMeterJpo(RegisterInfoByMeter registerInfoByMeter) {
        if(registerInfoByMeter != null){
            this.code = registerInfoByMeter.getCode();
            this.meterId = registerInfoByMeter.getMeterId();
            this.customerName = registerInfoByMeter.getCustomerName();
            this.mobileNumber = registerInfoByMeter.getMobileNumber();
        }
    }

    public RegisterInfoByMeter toDomain(){
        RegisterInfoByMeter registerInfoByMeter = new RegisterInfoByMeter();
        registerInfoByMeter.setCode(this.code);
        registerInfoByMeter.setMeterId(this.meterId);
        registerInfoByMeter.setCustomerName(this.customerName);
        registerInfoByMeter.setMobileNumber(this.mobileNumber);
        return registerInfoByMeter;
    }
}
