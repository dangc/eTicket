package com.nuri.etk.spec;

import com.nuri.etk.entity.API.Customer;
import com.nuri.etk.entity.API.Meter;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CustomerService {
    Customer getCustomerByNo(String customerNo);
}
