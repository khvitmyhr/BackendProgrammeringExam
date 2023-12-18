package com.machineFactory.customer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.machineFactory.Model.Customer;
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
public class CustomerEndToEndTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldGetAllCustomersAndGet200() throws Exception {
        mockMvc.perform(get("/api/customer/page/0"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReceive404FromCustomerControllerIfWrongURL() throws Exception {
        mockMvc.perform(get("/api/customers"))
                .andExpect(status().isNotFound());
    }


    @Test
    public void shouldDeleteFirstCustomerGet200() throws Exception {
        mockMvc.perform(delete("/api/customer/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldPostCustomerAndGet200() throws Exception {
        Customer customer = new Customer("Jens", "jens@gmail.com");

        mockMvc.perform(post("/api/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(customer)))
                .andExpect(status().isOk());
    }

    //Helper method for post method: see source in ReadMe
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

