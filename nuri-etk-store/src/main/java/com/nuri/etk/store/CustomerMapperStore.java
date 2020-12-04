package com.nuri.etk.store;

import com.nuri.etk.entity.API.ChargeHistory;
import com.nuri.etk.entity.API.MeterSerial;
import com.nuri.etk.store.jpo.CustomerJpo;
import com.nuri.etk.store.jpo.MeterSerialJpo;
import com.nuri.etk.store.mapper.CustomerMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperStore implements CustomerStore {

    private final CustomerMapper customerMapper;

    public CustomerMapperStore(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public ChargeHistory.Customer getCustomerByNo(String customerNo) {
        CustomerJpo customerJpo = null;
        try {
            customerJpo = customerMapper.getCustomerByNo(customerNo);
        } catch (Exception e){
            e.printStackTrace();
        }
        return customerJpo.toDomain();
    }

    @Override
    public MeterSerial getCustomerByMeter(String customerNo) {
        MeterSerialJpo meterSerialJpo = null;
        try {
            meterSerialJpo = customerMapper.getCustomerByMeter(customerNo);
        } catch (Exception e){
            e.printStackTrace();
        }
        return meterSerialJpo.toDomain();
    }
}
