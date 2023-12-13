package com.machineFactory.customer;

import com.machineFactory.Controller.CustomerController;
import com.machineFactory.Model.Customer;
import com.machineFactory.Repository.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
@Transactional
public class CustomerIntegrationTest {

    @Autowired
    private CustomerController customerController;
    @Autowired
    private CustomerRepo customerRepo;

    @Test
    public void testCustomer(){
        //Customer customer = new Customer("Ivar");
        //customerRepo.save(customer);
        //Customer Customer = customerController.getCustomerById(customer.getCustomerId());
        //assertEquals(HttpStatus.OK, Customer.());
        // assertEquals("Ivar", Customer.getCustomerName());
    }
}