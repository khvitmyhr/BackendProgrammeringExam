package com.machineFactory.Repository;

import com.machineFactory.Model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepo extends JpaRepository<Machine, Long> {
}
