package com.machineFactory.Service;

import com.machineFactory.Model.OrderModel;
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

    public OrderModel findOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }

    public OrderModel createOrderModel(OrderModel orderModel) {
        return orderRepo.save(orderModel);
    }

    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }
}
