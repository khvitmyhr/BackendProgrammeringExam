package com.machineFactory.Service;

import com.machineFactory.Model.OrderModel;
import com.machineFactory.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<OrderModel> getAllOrdreWithPagination(int pageNr) {
        return orderRepo.findAll(PageRequest.of(pageNr, 5)).stream().toList();
    }

    public List<OrderModel> getAllOrders() {
        return orderRepo.findAll();
    }

    public OrderModel createOrderModel(OrderModel orderModel) {
        return orderRepo.save(orderModel);
    }

    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }

    public boolean updateNameOrderCustomer(Long id, String newName) {
        OrderModel order = orderRepo.findById(id).orElse(null);

        if (order != null) {
            order.getCustomer().setCustomerName(newName);
            orderRepo.save(order);
            return true;
        }
        return false;
    }
}
