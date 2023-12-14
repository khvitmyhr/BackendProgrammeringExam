package com.machineFactory.address;

import com.machineFactory.Repository.AddressRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AddressRepoUnitTest {
    @Autowired
    private AddressRepo addressRepo;
    @Test
    public void AddressTestRepo(){}
}
