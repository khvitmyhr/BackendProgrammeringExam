package com.machineFactory.machine;

import com.machineFactory.Service.MachineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class MachineIntegrationTest {

    @Autowired
    MachineService machineService;

    @Autowired
    MockMvc mockMvc;

    @Test
    @Transactional
    void shouldFetchAllMachinesEqualsFromPag1ExpectIsEmpty(){
        var machines = machineService.getAllMachinesWithPagination(1);
        assert machines.isEmpty();
    }

    @Test
    @Transactional
    void shouldFetchMachinesFromPage1ShouldAsseryEmpty(){

        var machines = machineService.getAllMachinesWithPagination(1);
        assert machines.isEmpty();
    }

    //Test from Jason repo, see readme for resource
    @Test
    void shouldFetchMachines() throws Exception {
        mockMvc.perform(get("/api/machine/page/0"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchMachinesNotFoundIfURLIsWrong() throws Exception {
        mockMvc.perform(get("/api/machines"))
                .andExpect(status().isNotFound())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }
}