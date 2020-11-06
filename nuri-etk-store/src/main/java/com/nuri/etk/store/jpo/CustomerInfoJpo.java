package com.nuri.etk.store.jpo;


import com.nuri.etk.entity.pojo.CustomerInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerInfoJpo {

    private String customerName;
    private String geocode;
    private String accountNo;
    private String tariffType;
    private String district;
    private String address;

    public CustomerInfoJpo(CustomerInfo customerInfo) {
        if(customerInfo != null){
            this.customerName = customerInfo.getCustomerName();
            this.geocode = customerInfo.getGeocode();
            this.accountNo = customerInfo.getAccountNo();
            this.tariffType = customerInfo.getTariffType();
            this.district = customerInfo.getDistrict();
            this.address = customerInfo.getAddress();
        }
    }

    public CustomerInfo toDomain() {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerName(this.customerName);
        customerInfo.setGeocode(this.geocode);
        customerInfo.setAccountNo(this.accountNo);
        customerInfo.setTariffType(this.tariffType);
        customerInfo.setDistrict(this.district);
        customerInfo.setAddress(this.address);
        return customerInfo;
    }

}
