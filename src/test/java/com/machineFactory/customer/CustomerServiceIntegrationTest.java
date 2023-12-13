package com.machineFactory.customer;

import com.machineFactory.Service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class CustomerServiceIntegrationTest {

        @Autowired
        CustomerService customerService;

        @Test
        @Transactional
        void shouldFetchAllCustomers(){

            var customers = customerService.getAllCustomers();
            assert customers.size() == 8;
        }
}
