package com.machineFactory.part;

import com.machineFactory.Service.PartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
public class PartIntegrationTest {

    @Autowired
    PartService partService;

    @Test
    @Transactional
    void shouldFetchAllPartsWithPagination(){

        var parts = partService.getAllPartsWithPagination(0);
        assert parts.size() == 4;
    }
}

