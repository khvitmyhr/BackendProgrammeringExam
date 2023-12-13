package com.machineFactory.part;

import com.machineFactory.Model.Part;
import com.machineFactory.Service.PartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
public class PartServiceIntegrationTest {

    @Autowired
    PartService partService;

    @Test
    @Transactional
    void shouldFetchAllPartsWithPagination(){

        var parts = partService.getAllPartsWithPagination(0);
        assert parts.size() == 4;
    }

    @Test
    @Transactional
    void shouldFetchPartsFromPage1ShouldAsseryEmpty(){

        var machines = partService.getAllPartsWithPagination(1);
        assert machines.isEmpty();
    }

    @Test
    @Transactional
    void shouldAddPart(){
        var machines = partService.createPart(new Part("Screw"));
        assert machines.getPartName().equals("Screw");
    }

}

