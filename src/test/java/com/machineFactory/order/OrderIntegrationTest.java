package com.machineFactory.order;

import com.machineFactory.Controller.CustomerController;
import com.machineFactory.Controller.OrderController;
import com.machineFactory.Repository.CustomerRepo;
import com.machineFactory.Repository.OrderRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class OrderIntegrationTest {
    @Autowired
    private OrderController orderController;
    @Autowired
    private OrderRepo orderRepo;

    @Test
    public void testOrder(){}
}
