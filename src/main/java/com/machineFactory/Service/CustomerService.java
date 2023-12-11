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

    public List<Customer> getAllCustomerWithPagination(int pageNumber) {
        return customerRepo.findAll(PageRequest.of(pageNumber, 5)).stream().toList();
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


    //Virker ikke enda
    public void putCustomer(Customer oldName, Customer newName) {
        getAllCustomers().set(getAllCustomers().indexOf(oldName), newName);
 }

    // Kode for å legge til addresse til eksisterende kunde
    public Customer addAddressToCustomer(Address address, Long id) {
        //Address address1 = new Address(address.getStreet(), address.getZipCode(), address.getCity());
        Customer customerToUpdate = findCustomerById(id);

        ArrayList<Address> list = new ArrayList<>();
        list.add(address);

        customerToUpdate.setAddresses(list);
        return customerRepo.save(customerToUpdate);
    }
}