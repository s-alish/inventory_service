package com.app.inventory_service.domain.order;

import com.app.inventory_service.domain.product.Product;

import java.time.LocalDateTime;

public class Order {
    private final Long id;
    private Product product;
    private int amount;
    private OrderType type;
    private LocalDateTime createdAt;

    public Order(Long id, Product product, int amount, OrderType type, LocalDateTime createdAt) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        this.id = id;
        this.product = product;
        this.amount = amount;
        this.type = type;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Product getProduct() { return product; }
    public int getAmount() { return amount; }
    public OrderType getType() { return type; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
