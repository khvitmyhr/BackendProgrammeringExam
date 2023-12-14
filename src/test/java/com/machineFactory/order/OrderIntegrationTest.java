package com.machineFactory.order;

import com.machineFactory.Service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class OrderIntegrationTest {

    @Autowired
    OrderService orderService;

    @Test
    @Transactional
    void shouldFetchOrderFromPage0ShouldEqual1(){

        var order = orderService.getAllOrdreWithPagination(0);
        assert order.size() == 1;
    }

}
