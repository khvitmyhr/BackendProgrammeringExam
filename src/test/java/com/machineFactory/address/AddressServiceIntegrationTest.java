package com.machineFactory.address;

import com.machineFactory.Model.Address;
import com.machineFactory.Service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class AddressServiceIntegrationTest {

    @Autowired
    AddressService addressService;

    @Test
    @Transactional
    void shouldCreateAddress(){
        var address = addressService.createAddress(new Address("Hesteveien 8", "9786", "Helgeland"));
        assert address.getStreet().equals("Hesteveien 8");
        assert address.getZipCode().equals("9786");
        assert address.getCity().equals("Helgeland");
    }

}
