package com.machineFactory.Repository;

import com.machineFactory.Model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepo extends JpaRepository<Part, Long> {

}
