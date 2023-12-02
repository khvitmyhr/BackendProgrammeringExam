package com.machineFactory.Repository;

import com.machineFactory.Model.Subassembly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubassemblyRepo extends JpaRepository<Subassembly, Long> {
}
