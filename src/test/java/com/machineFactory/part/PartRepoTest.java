package com.machineFactory.part;

import com.machineFactory.Repository.CustomerRepo;
import com.machineFactory.Repository.PartRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PartRepoTest {
    @Autowired
    private PartRepo partRepo;
    @Test
    public void PartTestRepo(){}
}
