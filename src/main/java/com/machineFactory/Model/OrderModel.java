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
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordermodel_seq_gen")
    @SequenceGenerator(name = "ordermodel_seq_gen", sequenceName = "ordermodel_seq", allocationSize = 1)
    @Column(name = "ordermodel_id")
    private Long machineorderId = 0L;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("ordermodel")
    @JoinColumn(name = "ordermodel_id")
    private List<Machine> machines = new ArrayList<>();

    public OrderModel(Customer customer, List<Machine> machines) {
        this.customer = customer;
        this.machines = machines;
    }
}
