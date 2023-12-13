package com.machineFactory.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderEndToEndTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldGetOneOrderAndGet200() throws Exception {
        mockMvc.perform(get("/api/order/1"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReceive404FromOrderControllerIfWrongURL() throws Exception {
        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldDeleteFirstOrderGet200() throws Exception {
        mockMvc.perform(delete("/api/order/{id}", 1))
                .andExpect(status().isOk());
    }
}

