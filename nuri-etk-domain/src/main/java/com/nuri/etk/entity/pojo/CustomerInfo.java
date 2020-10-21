package com.nuri.etk.entity.pojo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerInfo {

    private String customerName;
    private String geocode;
    private String accountNo;
    private String tariffType;
    private String district;
    private String address;

    public CustomerInfo(String customerName, String geocode, String accountNo, String tariffType, String district, String address) {
        this.customerName = customerName;
        this.geocode = geocode;
        this.accountNo = accountNo;
        this.tariffType = tariffType;
        this.district = district;
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "customerName='" + customerName + '\'' +
                ", geocode='" + geocode + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", tariffType='" + tariffType + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
