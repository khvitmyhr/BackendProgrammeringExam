package com.machineFactory.address;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.machineFactory.Model.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressEndToEndTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldGetAllAddressesAndGet200() throws Exception {
        mockMvc.perform(get("/api/address/page/0"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReceive404FromAddressControllerIfWrongURL() throws Exception {
        mockMvc.perform(get("/api/addresses"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldPostAddressAndGet200() throws Exception {
        Address address = new Address("Kyllingveien 3", "1999", "Bergen");

        mockMvc.perform(post("/api/address")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(address)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteFirstAddressGet200() throws Exception {
        mockMvc.perform(delete("/api/address/{id}", 1))
                .andExpect(status().isOk());
    }


    //Source used for post and delete method: https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
    //Helper method for the post Test, from the source page.
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

