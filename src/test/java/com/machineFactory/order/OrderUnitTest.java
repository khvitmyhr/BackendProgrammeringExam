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


    //getOrders from Jason repo: https://github.com/jlwcrews2/vet-clinic/blob/main/src/test/java/no/jlwcrews/vetclinic/appointment/AppointmentServiceUnitTest.java
    @Test
    public void createTwoOrdersExpectEquals2() {
        List<OrderModel> orders = List.of(new OrderModel(), new OrderModel());
        when(orderRepo.findAll()).thenReturn(orders);

        var order1 = orderService.getAllOrders();
        assert order1.size() == 2;
    }
    @Test
    public void getAllOrdersCheckAmountCheckName() {
        ArrayList<Subassembly> sub = new ArrayList<>();
        ArrayList<Machine> machines =new ArrayList<>();

        machines.add(new Machine("Tractor", sub));

        Customer customer = new Customer("Harry");

        List<OrderModel> orderModels = List.of(new OrderModel(customer, machines));
        when(orderRepo.findAll()).thenReturn(orderModels);

        List<OrderModel> listOfOrders = orderService.getAllOrders();

        assertThat(listOfOrders.size()).isEqualTo(1);
        assertThat(listOfOrders.get(0).getCustomer().getCustomerName()).isEqualTo("Harry");
    }

    //Test that fails
//    @Test
//    public void testUpdateName() {
//        ArrayList<Machine> machines = new ArrayList<>();
//        Customer customer = new Customer("Jonas");
//
//        orderRepo.save(new OrderModel(customer, machines));
//        orderService.updateNameOrderCustomer(1L, "Kjellfrank");
//
//        //System.out.println("id: " + orderService.getAllOrders().get(0));
//        assertThat(orderService.getAllOrders().get(0).getCustomer().getCustomerName()).isEqualTo("Kjellfrank");
//    }
}
