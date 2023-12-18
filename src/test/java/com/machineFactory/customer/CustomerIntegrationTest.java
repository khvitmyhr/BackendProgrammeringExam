package com.machineFactory.customer;

import com.machineFactory.Controller.CustomerController;
import com.machineFactory.Model.Customer;
import com.machineFactory.Repository.CustomerRepo;
import com.machineFactory.Service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerIntegrationTest {

        @Autowired
        CustomerService customerService;

        @Autowired
        CustomerRepo customerRepo;

        @Autowired
        CustomerController customerController;

        @Test
        @Transactional
        void shouldFetchAllCustomersExpects8(){
            var customers = customerService.getAllCustomers();
            assert customers.size() == 8;
        }

        @Test
        @Transactional
        void shouldFetchCustomersFromPage1Expect3(){
            var customers = customerService.getAllCustomerWithPagination(1);
            assert customers.size() == 3;
        }

        @Test
        @Transactional
        void shouldCreateCustomer(){
            var customer = customerService.createCustomer(new Customer("Jonas", "jonas@gmail.com"));
            assert customer.getCustomerName().equals("Jonas");
            assert customer.getCustomerEmail().equals("jonas@gmail.com");
        }

        @Test
        @Transactional
        void setCustomerName(){
            var customer = customerService.createCustomer(new Customer("Jonas", "jonas@gmail.com"));
            customer.setCustomerName("Kjell");
            assert customer.getCustomerName().equals("Kjell");
            assert customer.getCustomerEmail().equals("jonas@gmail.com");
        }


        @Autowired
        MockMvc mockMvc;

        //Test from Jason repo, see source in ReedMe
        @Test
        void shouldFetchCustomers() throws Exception {
            mockMvc.perform(get("/api/customer/page/0"))
                    .andExpect(status().isOk())
                    .andDo(result -> {
                        System.out.println(result.getResponse().getContentAsString());
                    });
        }
        @Test
        void shouldFetchCustomersExpectNotFoundWithWrongURL() throws Exception {
            mockMvc.perform(get("/api/customeres"))
                    .andExpect(status().isNotFound())
                    .andDo(result -> {
                        System.out.println(result.getResponse().getContentAsString());
                    });
        }

        @Test
        public void testCustomer(){
          Customer customer = new Customer("Ivar");
          customerRepo.save(customer);

          Customer Customer = customerController.getCustomerById(customer.getCustomerId());
          assert (true);
          assertEquals("Ivar", Customer.getCustomerName());
      }
}
