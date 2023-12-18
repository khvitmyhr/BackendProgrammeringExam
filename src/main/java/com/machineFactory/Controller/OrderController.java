package com.machineFactory.Controller;

import com.machineFactory.Model.Customer;
import com.machineFactory.Model.OrderModel;
import com.machineFactory.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/page/{pageNr}")
    public List<OrderModel> getOrderByPage(@PathVariable int pageNr) {
        return orderService.getAllOrdreWithPagination(pageNr);
    }

    @PostMapping
    public OrderModel createOrderModel(@RequestBody OrderModel orderModel) {
        return orderService.createOrderModel(orderModel);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @PutMapping ("/customer/{id}/{newName}")
    public ResponseEntity<String> updateCustomerInOrder(@PathVariable Long id, @PathVariable String newName) {
        if (orderService.updateNameOrderCustomer(id, newName)) {
            return new ResponseEntity<>("Order customer updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("No customer with this id", HttpStatus.NOT_FOUND);
    }
}
