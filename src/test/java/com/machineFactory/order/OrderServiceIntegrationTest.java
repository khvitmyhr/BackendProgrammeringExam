package com.machineFactory.order;

import com.machineFactory.Service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class OrderServiceIntegrationTest {

    @Autowired
    OrderService orderService;

}
