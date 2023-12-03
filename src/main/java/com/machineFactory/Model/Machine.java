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
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "machine_seq_gen")
    @SequenceGenerator(name = "machine_seq_gen", sequenceName = "machine_seq", allocationSize = 1)

    @Column(name = "machine_id")
    private Long machineId = 0L;

    @Column(name = "machine_name")
    private String machineName;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("machine")
    @JoinColumn(name = "machine_id")
    private List<Subassembly> subassemblies = new ArrayList<>();

}
