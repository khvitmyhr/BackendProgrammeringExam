package com.machineFactory.customer;

import com.machineFactory.Model.Customer;
import com.machineFactory.Repository.CustomerRepo;
import com.machineFactory.Service.CustomerService;
import org.junit.jupiter.api.Test;
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

    //This test fails when you have test data in commandline runner, see more in ReadMe
    @Test
     public void shouldreturn1CustomerFromMockedRepo() {

        List<Customer> customers = List.of(new Customer("Kjell"));
        when(customerRepo.findAll()).thenReturn(customers);

        List<Customer> listOfCustomers = customerService.getAllCustomers();

        assertThat(listOfCustomers.size()).isEqualTo(1);
        assertThat(listOfCustomers.get(0).getCustomerName()).isEqualTo("Kjell");
    }
}
