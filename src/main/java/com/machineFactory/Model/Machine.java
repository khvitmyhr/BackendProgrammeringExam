package com.machineFactory.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "machine_seq_gen")
    @SequenceGenerator(name = "machine_seq_gen", sequenceName = "machine_seq", allocationSize = 1)

    @Column(name = "machine_id")
    private Long machineId = 0L;

    @Column(name = "machine_name")
    private String machineName;

}
