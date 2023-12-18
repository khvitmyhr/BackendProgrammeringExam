package com.machineFactory.Service;
import com.machineFactory.Model.Address;
import com.machineFactory.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepo addressRepo;

    @Autowired
    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public Address findAddressById(Long id) {
        return addressRepo.findById(id).orElse(null);
    }

    public List<Address> getAllAddressesWithPagination(int pageNr) {
        return addressRepo.findAll(PageRequest.of(pageNr, 5)).stream().toList();
    }

    public List<Address> getAllAddresses() {
       return addressRepo.findAll();
    }

    public Address createAddress(Address address) {
        return addressRepo.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepo.deleteById(id);
    }

    public boolean updateAddress(Long id, String street) {
        Address ad = addressRepo.findById(id).orElse(null);
        if (ad != null) {
            ad.setStreet(street);
            addressRepo.save(ad);
            return true;
        }
        return false;
    }

//Code for adding address to existing customer through postman. Did not go thurder.
//    public Customer addAddressToCustomer(Address address, Long id) {
//        //Address address1 = new Address(address.getStreet(), address.getZipCode(), address.getCity());
//        Customer customerToUpdate = findCustomerById(id);
//        ArrayList<Address> list = new ArrayList<>();
//        list.add(address);
//        customerToUpdate.setAddresses(list);
//        return customerRepo.save(customerToUpdate);
//    }
}

