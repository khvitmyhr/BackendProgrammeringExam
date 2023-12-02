package com.example.machineFactory.Repository;

import com.example.machineFactory.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
