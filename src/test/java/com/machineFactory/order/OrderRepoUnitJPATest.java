package com.machineFactory.order;


import com.machineFactory.Model.OrderModel;
import com.machineFactory.Repository.OrderRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class OrderRepoUnitJPATest {

    @Autowired
    OrderRepo orderRepo;

    @Test
    void shouldFetchOrders(){
        List<OrderModel> orders = orderRepo.findAll();
        assert orders.size() == 1;
    }
    @Test
    void orderCustomerConfirmName(){
        OrderModel orderModel = orderRepo.findById(1L).get();
        assert orderModel.getCustomer().getCustomerName().equals("Jens");
    }

    @Test
    void orderContains1Machine(){
        OrderModel orderModel = orderRepo.findById(1L).get();
        assert orderModel.getMachines().size() == 1;
    }
}

//Tests inspired from Jason repo: https://github.com/jlwcrews2/jpa-demo/blob/master/src/test/java/no/jlwcrews/jpademo/DBUnitTesting.java