package com.machineFactory.Controller;

import com.machineFactory.Model.Address;
import com.machineFactory.Model.Customer;
import com.machineFactory.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressService;
    @Autowired
    public AddressController (AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressService.findAddressById(id);
    }

    @GetMapping("/page/{pageNr}")
    public List<Address> getAddressByPage(@PathVariable int pageNr) {
        return addressService.getAllAddressesWithPagination(pageNr);
    }

    @GetMapping
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddressById(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
    @PutMapping ("{id}/{newName}")
    public ResponseEntity<String> updateAddress(@PathVariable Long id, @PathVariable String newAddress) {
        if (addressService.updateAddress(id, newAddress)) {
            return new ResponseEntity<>("Address updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("No address with this id", HttpStatus.NOT_FOUND);
    }


}
