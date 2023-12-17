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
public class Subassembly {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subassembly_seq_gen")
    @SequenceGenerator(name = "subassembly_seq_gen", sequenceName = "subassembly_seq", allocationSize = 1)

    @Column(name = "subassembly_id")
    private Long subassemblyId = 0L;

    @Column(name = "subassembly_name")
    private String subassemblyName;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("subassembly")
    @JoinColumn(name = "subassembly_id")
    private List<Part> parts = new ArrayList<>();

    public Subassembly(String subassemblyName, List<Part> parts) {
        this.subassemblyName = subassemblyName;
        this.parts = parts;
    }

    public Subassembly(String subassemblyName) {
        this.subassemblyName = subassemblyName;
    }
}
