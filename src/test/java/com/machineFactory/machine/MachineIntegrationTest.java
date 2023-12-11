package com.machineFactory.machine;

import com.machineFactory.Controller.CustomerController;
import com.machineFactory.Controller.MachineController;
import com.machineFactory.Repository.CustomerRepo;
import com.machineFactory.Repository.MachineRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MachineIntegrationTest {
    @Autowired
    private MachineController machineController;
    @Autowired
    private MachineRepo machineRepo;

    @Test
    public void testMachine(){}
}
