package com.machineFactory.Service;

import com.machineFactory.Model.Address;
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

    public List<OrderModel> getAllOrdreWithPagination(int pageNumber) {
        return orderRepo.findAll(PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public OrderModel createOrderModel(OrderModel orderModel) {
        return orderRepo.save(orderModel);
    }

    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }
}
