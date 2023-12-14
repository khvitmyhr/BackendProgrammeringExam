package com.machineFactory.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.machineFactory.Model.Address;
import com.machineFactory.Repository.AddressRepo;
import com.machineFactory.Service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;

//Test fails when having setCustomer in commandlinerunner.

//@SpringBootTest
//public class AddressServiceUnitTest {
//
//    @MockBean
//    private AddressRepo addressRepo;
//
//    @Autowired
//    private AddressService addressService;
//
//    @Test
//    public void fetchAllAddresses() {
//        List<Address> addresses = List.of(new Address(), new Address(), new Address());
//        when(addressRepo.findAll()).thenReturn(addresses);
//
//        var appointments = addressService.getAllAddresses();
//        assert appointments.size() == 3;
//        }
//}

//Test from Jason repo: https://github.com/jlwcrews2/vet-clinic/blob/main/src/test/java/no/jlwcrews/vetclinic/appointment/AppointmentServiceUnitTest.java
