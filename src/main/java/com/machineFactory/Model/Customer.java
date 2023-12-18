package com.machineFactory.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
    @SequenceGenerator(name = "customer_seq_gen", sequenceName = "customer_seq", allocationSize = 1)

    @Column(name = "customer_id")
    private Long customerId = 0L;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> addresses = new ArrayList<>();


    @OneToMany (cascade = CascadeType.ALL)
    @JsonIgnoreProperties("customer")
    @JoinColumn(name = "customer_id")
    private List<OrderModel> orders = new ArrayList<>();

    public Customer(String customerName, String customerEmail) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public Customer(String customerName) {
        this.customerName = customerName;
    }
}
