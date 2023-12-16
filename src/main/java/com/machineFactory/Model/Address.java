package com.machineFactory.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq_gen")
    @SequenceGenerator(name = "address_seq_gen", sequenceName = "address_seq", allocationSize = 1)

    @Column(name = "address_id")
    private Long addressId = 0L;

    @Column(name = "street")
    private String street;

    @Column(name = "zip_Code")
    private String zipCode;

    @Column(name = "city")
    private String city;


    @ManyToMany(mappedBy = "addresses", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Customer> customers = new ArrayList<>();

    public Address(String street, String zipCode, String city) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }
}
