package com.machineFactory.machine;

import com.machineFactory.Repository.CustomerRepo;
import com.machineFactory.Repository.MachineRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class MachineRepoTest {
    @Autowired
    private MachineRepo machineRepo;
    @Test
    public void MachineTestRepo(){}
}
