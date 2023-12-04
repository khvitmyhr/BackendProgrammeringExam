package com.machineFactory.Controller;


import com.machineFactory.Model.OrderModel;
import com.machineFactory.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public OrderModel getOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }
    @PostMapping
    public OrderModel createOrderModel(@RequestBody OrderModel orderModel) {
        return orderService.createOrderModel(orderModel);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
