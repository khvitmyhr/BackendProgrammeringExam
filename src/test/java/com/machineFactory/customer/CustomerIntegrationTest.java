package com.machineFactory.customer;

import com.machineFactory.Model.Customer;
import com.machineFactory.Service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class CustomerIntegrationTest {

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

    @Test
    public void testCustomer(){
        //Customer customer = new Customer("Ivar");
        //customerRepo.save(customer);
        //Customer Customer = customerController.getCustomerById(customer.getCustomerId());
        //assertEquals(HttpStatus.OK, Customer.());
        // assertEquals("Ivar", Customer.getCustomerName());
    }
}
