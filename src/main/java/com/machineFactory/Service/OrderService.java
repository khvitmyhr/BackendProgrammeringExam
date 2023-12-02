package com.machineFactory.Service;

import com.machineFactory.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

}
