package com.nuri.etk.logic;

import com.nuri.etk.entity.API.ChargeHistory;
import com.nuri.etk.entity.API.MeterSerial;
import com.nuri.etk.spec.CustomerService;
import com.nuri.etk.store.CustomerStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerLogic implements CustomerService {

    private final CustomerStore customerStore;

    public CustomerLogic(CustomerStore customerStore) {
        this.customerStore = customerStore;
    }

    @Override
    public ChargeHistory.Customer getCustomerByNo(String customerNo) {
        ChargeHistory.Customer customer = new ChargeHistory.Customer(customerStore.getCustomerByNo(customerNo));
        if(customer != null){
            customer.setCode(200);
        }
        return customer;
    }

    @Override
    public MeterSerial getCustomerByMeter(String customerNo) {
        MeterSerial meterSerial = new MeterSerial(customerStore.getCustomerByMeter(customerNo));
        if(meterSerial != null){
            meterSerial.setCode(200);
        }
        return meterSerial;
    }
}
