package com.machineFactory.Controller;

import com.machineFactory.Model.Address;
import com.machineFactory.Model.Customer;
import com.machineFactory.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping("/page/{pageNr}")
    public List<Customer> getCustomerByPage(@PathVariable int pageNr) {
        return customerService.getAllCustomerWithPagination(pageNr);
    }

    //Kode for å legge til addresse til eksisterende. bruker ID i url for å identifisere og finne kunde
    //Muligens fjerne denne, gjøre via main istedet
    @PostMapping("/customerId/{id}")
    public Customer createAddressToCustomer(@RequestBody Address address, @PathVariable Long id) {
       return customerService.addAddressToCustomer(address, id);
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping ("{id}/{newName}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @PathVariable String newName) {
        if (customerService.updateNameCustomer(id, newName)) {
            return new ResponseEntity<>("Customer updated", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}