package com.machineFactory.subassembly;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SubassemblyEndToEndTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldGetOneSubassemblyAndGet200() throws Exception {
        mockMvc.perform(get("/api/subassembly/1"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReceive404FromSubassemblyControllerIfWrongURL() throws Exception {
        mockMvc.perform(get("/api/subassemblys"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldDeleteFirstSubassemblyGet200() throws Exception {
        mockMvc.perform(delete("/api/subassembly/{id}", 1))
                .andExpect(status().isOk());
    }
}

