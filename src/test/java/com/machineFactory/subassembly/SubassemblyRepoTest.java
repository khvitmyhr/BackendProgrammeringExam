package com.machineFactory.subassembly;

import com.machineFactory.Repository.CustomerRepo;
import com.machineFactory.Repository.SubassemblyRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class SubassemblyRepoTest {
    @Autowired
    private SubassemblyRepo subassemblyRepo;
    @Test
    public void SubassemblyTestRepo(){}
}
