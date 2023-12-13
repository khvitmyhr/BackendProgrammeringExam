package com.machineFactory.customer;

import com.machineFactory.Model.Customer;
import com.machineFactory.Model.Part;
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

        @Test
        @Transactional
        void shouldCreateCustomer(){
            var customer = customerService.createCustomer(new Customer("Jonas", "jonas@gmail.com"));
            assert customer.getCustomerName().equals("Jonas");
            assert customer.getCustomerEmail().equals("jonas@gmail.com");
        }

        @Test
        @Transactional
        void setCustomerName(){
            var customer = customerService.createCustomer(new Customer("Jonas", "jonas@gmail.com"));
            customer.setCustomerName("Kjell");
            assert customer.getCustomerName().equals("Kjell");
            assert customer.getCustomerEmail().equals("jonas@gmail.com");
        }
}
