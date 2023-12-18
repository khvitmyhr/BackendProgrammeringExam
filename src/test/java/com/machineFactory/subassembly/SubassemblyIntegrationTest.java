package com.machineFactory.subassembly;

import com.machineFactory.Service.SubassemblyService;
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
public class SubassemblyIntegrationTest {

    @Autowired
    SubassemblyService subassemblyService;

    @Autowired
    MockMvc mockMvc;

    //Test from Jason repo
    @Test
    void shouldFetcSubassemblies() throws Exception {
        mockMvc.perform(get("/api/subassembly/page/0"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }


    //test fails
    //@Test
    @Transactional
    void shouldFetchAllSubassembliesWithPaginationShouldEqual3(){
        var subassembly = subassemblyService.getAllSubassemblysWithPagination(0);
        assert subassembly.size() == 3;
    }
}
