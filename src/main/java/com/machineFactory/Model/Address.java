package com.machineFactory.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "zipCode") //postnr
    private int zipCode;

    @Column(name = "city")
    private String city;


}
