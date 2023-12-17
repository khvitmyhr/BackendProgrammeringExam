package com.machineFactory.address;

import com.machineFactory.Model.Address;
import com.machineFactory.Repository.AddressRepo;
import com.machineFactory.Service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AddressUnitTest {

    @MockBean
    AddressRepo addressRepo;

    @Autowired
    AddressService addressService;

    //This test fails when you have test data in commandline runner available, see more in ReadMe
    @Test
    public void shouldreturn1AddressFromMockedRepo() {

        List<Address> addresses = List.of(new Address("Kyllingveien 3", "9999", "Hallingdal"));
        when(addressRepo.findAll()).thenReturn(addresses);

        List<Address> listOfAddresses = addressService.getAllAddresses();

        assertThat(listOfAddresses.size()).isEqualTo(1);
        assertThat(listOfAddresses.get(0).getStreet()).isEqualTo("Kyllingveien 3");
        assertThat(listOfAddresses.get(0).getZipCode()).isEqualTo("9999");
        assertThat(listOfAddresses.get(0).getCity()).isEqualTo("Hallingdal");
    }
}
