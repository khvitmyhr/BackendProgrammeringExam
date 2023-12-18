package com.machineFactory.address;


import com.machineFactory.Model.Address;
import com.machineFactory.Service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AddressService addressService;

    @Test
    @Transactional
    void shouldCreateAddress() {
        var address = addressService.createAddress(new Address("Hesteveien 8", "9786", "Helgeland"));
        assert address.getStreet().equals("Hesteveien 8");
        assert address.getZipCode().equals("9786");
        assert address.getCity().equals("Helgeland");
    }

    @Test
    void shouldFetchAddressesExpectNotFoundWithWrongURL() throws Exception {
        mockMvc.perform(get("/api/addresseses"))
                .andExpect(status().isNotFound())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchAddressesExpectIsOk() throws Exception {
        mockMvc.perform(get("/api/address/page/0"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }
}
//shouldFetchAddresses is from Jason repo: https://github.com/jlwcrews2/vet-clinic/blob/main/src/test/java/no/jlwcrews/vetclinic/appointment/AppointmentIntegrationTest.java
