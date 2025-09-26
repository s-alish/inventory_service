package com.app.inventory_service.domain.product;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long id);
    List<Product> findAll();
    void save(Product product);
    void deleteById(Long id);
}
