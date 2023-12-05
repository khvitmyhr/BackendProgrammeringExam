package com.machineFactory.Service;

import com.machineFactory.Model.Address;
import com.machineFactory.Model.Customer;
import com.machineFactory.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;
    @Autowired
    CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
    public Customer findCustomerById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    public List<Customer> getAllCustomerWithPagination(int pageNumber) {
        return customerRepo.findAll(PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }
}
