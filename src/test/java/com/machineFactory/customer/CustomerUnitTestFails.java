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
public class CustomerUnitTestFails {

    @MockBean
    CustomerRepo customerRepo;

    @Autowired
    CustomerService customerService;

    //This test fails
    @Test
     public void shouldreturn1CustomerFromMockedRepo() {

        Customer customer = customerRepo.save(new Customer("Kjell"));

        when(customerRepo.save(customer)).thenReturn(customer);

        customerService.createCustomer(customer);
        List<Customer> listOfCustomers = customerService.getAllCustomers();

        assertThat(listOfCustomers.size()).isEqualTo(1);
        assertThat(listOfCustomers.get(0).getCustomerName()).isEqualTo("Kjell");
    }
}
