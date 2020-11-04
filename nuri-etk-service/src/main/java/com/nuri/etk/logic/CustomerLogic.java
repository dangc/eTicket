package com.nuri.etk.logic;

import com.nuri.etk.entity.API.Customer;
import com.nuri.etk.spec.CustomerService;
import com.nuri.etk.store.CustomerStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerLogic implements CustomerService {

    private final CustomerStore customerStore;

    public CustomerLogic(CustomerStore customerStore) {
        this.customerStore = customerStore;
    }

    @Override
    public Customer getCustomerByNo(String customerNo) {
        return customerStore.getCustomerByNo(customerNo);
    }
}
