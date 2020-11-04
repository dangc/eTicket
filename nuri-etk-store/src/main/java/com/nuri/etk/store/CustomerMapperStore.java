package com.nuri.etk.store;

import com.nuri.etk.entity.API.Customer;
import com.nuri.etk.store.jpo.CustomerJpo;
import com.nuri.etk.store.mapper.CustomerMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapperStore implements CustomerStore {

    private final CustomerMapper customerMapper;

    public CustomerMapperStore(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer getCustomerByNo(String customerNo) {
        CustomerJpo customerJpo = null;
        try {
            customerJpo = customerMapper.getCustomerByNo(customerNo);
        } catch (Exception e){
            e.printStackTrace();
        }
        return customerJpo.toDomain();
    }
}
