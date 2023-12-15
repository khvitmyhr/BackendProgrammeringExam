package com.machineFactory.machine;

import com.machineFactory.Model.Machine;
import com.machineFactory.Repository.MachineRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class MachineRepoUnitJPATest {

        @Autowired
        MachineRepo machineRepo;
        @Test
        void shouldFetchAllMachines(){
            List<Machine> machines = machineRepo.findAll();
            assert machines.size() == 2;
        }
}

//Test from Jason repo: https://github.com/jlwcrews2/jpa-demo/blob/master/src/test/java/no/jlwcrews/jpademo/DBUnitTesting.java
