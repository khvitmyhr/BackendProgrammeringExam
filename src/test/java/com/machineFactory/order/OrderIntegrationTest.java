package com.machineFactory.order;

import com.machineFactory.Service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class OrderIntegrationTest {

    @Autowired
    OrderService orderService;

    @Autowired
    MockMvc mockMvc;

    @Test
    @Transactional
    void shouldFetchOrderFromPage0ShouldEqual1(){

        var order = orderService.getAllOrdreWithPagination(0);
        assert order.size() == 1;
    }

    //Tests from Jason repo, source in readMe
    @Test
    void shouldFetchOrders() throws Exception {
        mockMvc.perform(get("/api/order/page/0"))
                .andExpect(status().isOk())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

    @Test
    void shouldFetchOrdersExpectNotFoundWithWrongURL() throws Exception {
        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isNotFound())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }
}
