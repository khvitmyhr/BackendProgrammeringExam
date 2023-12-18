package com.machineFactory.part;

import com.machineFactory.Model.Part;
import com.machineFactory.Service.PartService;
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
public class PartIntegrationTest {

    @Autowired
    PartService partService;

    @Autowired
    MockMvc mockMvc;


    @Test
    @Transactional
    void shouldAddPart(){
        var machines = partService.createPart(new Part("Screw"));
        assert machines.getPartName().equals("Screw");
    }

    //Test from Jason repo, source in readme
    @Test
    void shouldFetchParts() throws Exception {
        mockMvc.perform(get("/api/part/page/0"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    //@Test
    //@Transactional
    void shouldFetchPartsFromPage1ShouldAsseryEmpty(){
        var machines = partService.getAllPartsWithPagination(1);
        assert machines.isEmpty();
    }
}

