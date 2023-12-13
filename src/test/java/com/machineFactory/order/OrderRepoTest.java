package com.machineFactory.order;

import com.machineFactory.Repository.CustomerRepo;
import com.machineFactory.Repository.OrderRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class OrderRepoTest {
    @Autowired
    private OrderRepo orderRepo;
    @Test
    public void OrderTestRepo(){}
}
