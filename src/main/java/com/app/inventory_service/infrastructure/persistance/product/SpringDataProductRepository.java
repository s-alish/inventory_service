package com.app.inventory_service.infrastructure.persistance.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity, Long> {
}
