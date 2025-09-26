package com.app.inventory_service.domain.order;

import java.util.List;
import java.util.Optional;


public interface OrderRepository {
    Optional<Order> findById(Long id);
    List<Order> findAll();
    void save(Order order);
    void deleteById(Long id);
}