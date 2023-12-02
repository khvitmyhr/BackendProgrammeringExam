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

    @OneToMany (cascade = CascadeType.ALL)
    @JsonIgnoreProperties("address")
    @JoinColumn(name = "address_id")
    private List<Address> addresses = new ArrayList<>();

    @OneToMany (cascade = CascadeType.ALL)
    @JsonIgnoreProperties("orders")
    @JoinColumn(name = "order_id")
    private List<Order> orders = new ArrayList<>();


}
