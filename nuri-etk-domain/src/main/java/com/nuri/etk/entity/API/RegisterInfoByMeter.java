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

    public static RegisterInfoByMeter getRegisterInfoByMeter(String meterId) {
        RegisterInfoByMeter meter = new RegisterInfoByMeter(200, meterId, "ECGCustomer", "+233 24-323-4545");
        System.out.println("######## getRegisterInfoByMeter return : " + meter.toString() + " ########");
        return meter;
    }

    @Override
    public String toString() {
        return "RegisterInfoByMeter{" +
                "code=" + code +
                ", meterId='" + meterId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
