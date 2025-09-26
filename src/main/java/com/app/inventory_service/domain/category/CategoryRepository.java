package com.app.inventory_service.domain.category;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findById(Long id);
    List<Category> findAll();
    void save(Category category);
    void deleteById(Long id);
}
