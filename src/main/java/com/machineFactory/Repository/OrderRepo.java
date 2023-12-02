package com.machineFactory.Repository;

import com.machineFactory.Model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderModel, Long> {
}
