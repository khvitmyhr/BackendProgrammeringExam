package com.machineFactory.part;

import com.machineFactory.Controller.PartController;
import com.machineFactory.Repository.PartRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class PartIntegrationTest {
    @Autowired
    private PartController partController;
    @Autowired
    private PartRepo partRepo;

    @Test
    public void testPart(){}
}
