package com.example.machineFactory.Service;

import com.example.machineFactory.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepo addressRepo;

    @Autowired
    AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }


}
