package com.app.inventory_service.infrastructure.persistance.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SpringDataCategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
