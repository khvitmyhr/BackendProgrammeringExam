package com.machineFactory.Controller;

import com.machineFactory.Model.Address;
import com.machineFactory.Model.Customer;
import com.machineFactory.Service.AddressService;
import com.machineFactory.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<Customer> getAllCustomer(){
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

    //Påbegynt metode for å legge til addresse
//    @PostMapping("/{id}")
//    public void addAddressToCustomer(@PathVariable Long id, @RequestBody Address address) {
//        final AddressService addressService;
//
//        address.getCustomers();
//    }



    //Påbegynt put virker ikke helt
//    @PutMapping ("{oldName}/{newName}")
//    public void updateCustomer(@PathVariable String oldName, @PathVariable String newName) {
//        customerService.putCustomer(oldName, newName);
//    }


}