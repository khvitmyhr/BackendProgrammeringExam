package com.machineFactory.customer;

import com.machineFactory.Model.Customer;
import com.machineFactory.Repository.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CustomerRepoUnitJPATest {

    @Autowired
    private CustomerRepo customerRepo;

    @Test
    public void SaveACustomerToRepo(){
        Customer customer = new Customer("Ivers");
        customerRepo.save(customer);
    }

    @Test
    void putAddressOnCustomer(){
        Customer customer = customerRepo.findById(1L).get();
        assert customer.getAddresses().size() == 1;
    }
}

//Tests from Jason repo: https://github.com/jlwcrews2/jpa-demo/blob/master/src/test/java/no/jlwcrews/jpademo/DBUnitTesting.java