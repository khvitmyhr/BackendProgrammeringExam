package com.machineFactory.order;

import com.machineFactory.Model.*;
import com.machineFactory.Repository.OrderRepo;
import com.machineFactory.Service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderUnitTest {

    @MockBean
    private OrderRepo orderRepo;

    @Autowired
    private OrderService orderService;

    @Test
    public void getOrders() {
        List<OrderModel> orders = List.of(new OrderModel(), new OrderModel());
        when(orderRepo.findAll()).thenReturn(orders);

        var order1 = orderService.getAllOrders();
        assert order1.size() == 2;
    }

    //Were not able to make this test work
//    @Test
//    public void getAllOrders() {
//        ArrayList<Subassembly> sub = new ArrayList<>();
//        ArrayList<Machine> mach =new ArrayList<>();
//        mach.addAll(sub);
//        Customer customer = new Customer("Harry");
//        Machine mach = new Machine("Tractor", sub);
//
//        List<OrderModel> orderModels = List.of(new OrderModel(customer, mach);
//        when(orderRepo.findAll()).thenReturn(orderModels);
//
//        List<OrderModel> listOfOrders = orderService.getAllOrders();
//
//        assertThat(listOfOrders.size()).isEqualTo(1);
//        assertThat(listOfOrders.get(0).getCustomer()).isEqualTo("Harry");
//    }
}
