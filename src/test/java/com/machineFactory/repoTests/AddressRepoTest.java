package com.machineFactory.repoTests;

import com.machineFactory.Repository.AddressRepo;
import com.machineFactory.Repository.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AddressRepoTest {
    @Autowired
    private AddressRepo addressRepo;
    @Test
    public void AddressTestRepo(){}
}
