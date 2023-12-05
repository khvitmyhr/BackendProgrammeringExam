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

@SpringBootTest
public class AddressServiceUnitTest {

    @MockBean
    private AddressRepo addressRepo;

    @Autowired
    private AddressService addressService;

    @Test
    public void shouldFetcAddresses() {
        List<Address> appointmentList = List.of(new Address(), new Address(), new Address());
        when(addressRepo.findAll()).thenReturn(appointmentList);

        var appointments = addressService.getAllAddresses();
        assert appointments.size() == 3;
        }
}
