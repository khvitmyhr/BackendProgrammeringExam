package com.example.machineFactory.Service;

import com.example.machineFactory.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

}
