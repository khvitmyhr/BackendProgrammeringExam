package com.machineFactory.part;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PartEndToEndTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldGetOnePartsAndGet200() throws Exception {
        mockMvc.perform(get("/api/part/1"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReceive404FromPartControllerIfWrongURL() throws Exception {
        mockMvc.perform(get("/api/parts"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldDeleteFirstPartGet200() throws Exception {
        mockMvc.perform(delete("/api/part/{id}", 1))
                .andExpect(status().isOk());
    }

}

