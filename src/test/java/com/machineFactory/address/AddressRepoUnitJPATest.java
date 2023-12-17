package com.machineFactory.address;

import com.machineFactory.Model.Address;
import com.machineFactory.Repository.AddressRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AddressRepoUnitJPATest {

    @Autowired
    private AddressRepo addressRepo;

    @Test
    public void SaveAddressToRepo() {
        Address address = new Address("Kyllingveien 3", "9999", "Hallingdal");
        addressRepo.save(address);
    }

    @Test
    void AddCustomerToAddress(){
        Address address = addressRepo.findById(1L).get();
        assert address.getCustomers().size() == 1;
    }
}

//Tests from Jason repo: https://github.com/jlwcrews2/jpa-demo/blob/master/src/test/java/no/jlwcrews/jpademo/DBUnitTesting.java

