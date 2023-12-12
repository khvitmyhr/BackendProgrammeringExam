package com.machineFactory.Service;
import com.machineFactory.Model.Address;
import com.machineFactory.Model.Customer;
import com.machineFactory.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Address> getAllAddressesWithPagination(int pageNumber) {
        return addressRepo.findAll(PageRequest.of(pageNumber, 5)).stream().toList();
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
}
