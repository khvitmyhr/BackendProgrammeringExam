package com.machineFactory.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "machineorder_seq_gen")
    @SequenceGenerator(name = "machineorder_seq_gen", sequenceName = "machineorder_seq", allocationSize = 1)
    @Column(name = "machineorder_id")

    private Long machineorderId = 0L;


}
