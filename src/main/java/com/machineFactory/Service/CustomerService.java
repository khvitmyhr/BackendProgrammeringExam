package com.machineFactory.Service;

import com.machineFactory.Model.Address;
import com.machineFactory.Model.Customer;
import com.machineFactory.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Customer> getAllCustomerWithPagination(int pageNr) {
        return customerRepo.findAll(PageRequest.of(pageNr, 5)).stream().toList();
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }

    public boolean updateNameCustomer(Long id, String newName) {
        Customer cus = customerRepo.findById(id).orElse(null);
        if (cus != null) {
            cus.setCustomerName(newName);
            customerRepo.save(cus);
            return true;
        }
        return false;
    }


    //See comment in CustomerController/readme for this cancelled method.
    public Customer addAddressToCustomer(Address address, Long id) {
        //Address address1 = new Address(address.getStreet(), address.getZipCode(), address.getCity());
        Customer customerToUpdate = findCustomerById(id);

        ArrayList<Address> list = new ArrayList<>();
        list.add(address);

        customerToUpdate.setAddresses(list);
        return customerRepo.save(customerToUpdate);
    }
}