package com.machineFactory.machine;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MachineEndToEndTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldGetOneMachineAndGet200() throws Exception {
        mockMvc.perform(get("/api/machine/1"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReceive404FromMachineControllerIfWrongURL() throws Exception {
        mockMvc.perform(get("/api/machines"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldDeleteFirstMachineGet200() throws Exception {
        mockMvc.perform(delete("/api/machine/1"))
                .andExpect(status().isOk());
    }
}

