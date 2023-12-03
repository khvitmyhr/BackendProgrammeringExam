package com.machineFactory.Service;

import com.machineFactory.Model.Customer;
import com.machineFactory.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;
    @Autowired
    CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
    public Customer findCustomerById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }


}
