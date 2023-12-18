package com.machineFactory.customer;

import com.machineFactory.Model.Customer;
import com.machineFactory.Repository.CustomerRepo;
import com.machineFactory.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerUnitTest {

    @MockBean
    CustomerRepo customerRepo;

    @Autowired
    CustomerService customerService;


    //These tests fail when you have test data in commandline runner available, see more in ReadMe.
    //By adding an exclamation mark in the if-statement in Main class l:41, this test run properly. (also remover the outcommented test)

    //@Test
     public void shouldreturn1CustomerFromMockedRepo() {

        List<Customer> customers = List.of(new Customer("Kjell"));
        when(customerRepo.findAll()).thenReturn(customers);

        List<Customer> listOfCustomers = customerService.getAllCustomers();

        assertThat(listOfCustomers.size()).isEqualTo(1);
        assertThat(listOfCustomers.get(0).getCustomerName()).isEqualTo("Kjell");
    }

    //@Test
    public void createTwoCustomersExpectEquals2() {
        List<Customer> customers = List.of(new Customer(), new Customer());
        when(customerRepo.findAll()).thenReturn(customers);

        var customer = customerService.getAllCustomers();
        assert customer.size() == 2;
    }
}
