package com.machineFactory.customer;

import com.machineFactory.Model.Customer;
import com.machineFactory.Repository.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class CustomerRepoTest {
    @Autowired
    private CustomerRepo customerRepo;
    @Test
    public void CustomerTestRepo(){
        Customer customer = new Customer("Ivers");
        customerRepo.save(customer);
        //List<Customer>foundHim = customerRepo.find
    }
}
