package com.example.machineFactory.Repository;

import com.example.machineFactory.Model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepo extends JpaRepository<Part, Long> {

}
