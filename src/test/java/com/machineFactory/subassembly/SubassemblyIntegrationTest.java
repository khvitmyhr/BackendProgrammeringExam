package com.machineFactory.subassembly;

import com.machineFactory.Service.SubassemblyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class SubassemblyIntegrationTest {

    @Autowired
    SubassemblyService subassemblyService;

    @Test
    @Transactional
    void shouldFetchAllSubassembliesWithPaginationShouldEqual3(){

        var subassembly = subassemblyService.getAllSubassemblysWithPagination(0);
        assert subassembly.size() == 3;
    }

}
