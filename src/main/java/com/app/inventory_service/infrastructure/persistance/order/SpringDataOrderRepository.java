package com.app.inventory_service.infrastructure.persistance.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SpringDataOrderRepository extends JpaRepository<OrderEntity, Long> {
}
