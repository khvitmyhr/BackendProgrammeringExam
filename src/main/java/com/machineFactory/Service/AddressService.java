package com.machineFactory.Service;

import com.machineFactory.Model.Address;
import com.machineFactory.Model.Customer;
import com.machineFactory.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepo addressRepo;

    @Autowired
    AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public Address findAddressById(Long id) {
        return addressRepo.findById(id).orElse(null);
    }

}
