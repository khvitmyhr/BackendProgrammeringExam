package com.machineFactory.subassembly;

import com.machineFactory.Controller.SubassemblyController;
import com.machineFactory.Repository.SubassemblyRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class SubassemblyIntegrationTest {
    @Autowired
    private SubassemblyController subassemblyController;
    @Autowired
    private SubassemblyRepo subassemblyRepo;

    @Test
    public void testSubassembly(){}
}
