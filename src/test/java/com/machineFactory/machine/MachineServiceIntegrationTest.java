package com.machineFactory.machine;

import com.machineFactory.Service.MachineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MachineServiceIntegrationTest {

    @Autowired
    MachineService machineService;

    @Test
    @Transactional
    void shouldFetchAllMachinesEquals2(){

        var machines = machineService.getAllMachinesWithPagination(0);
        assert machines.size() == 2;
    }

    @Test
    @Transactional
    void shouldFetchMachinesFromPage1ShouldAsseryEmpty(){

        var machines = machineService.getAllMachinesWithPagination(1);
        assert machines.isEmpty();
    }
}