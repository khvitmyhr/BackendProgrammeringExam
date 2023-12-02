package com.example.machineFactory.Repository;

import com.example.machineFactory.Model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepo extends JpaRepository<Machine, Long> {
}
