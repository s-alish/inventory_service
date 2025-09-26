package com.app.inventory_service.domain.product;

import com.app.inventory_service.domain.category.Category;

public class Product {
    private final Long id;
    private String name;
    private Category category;
    private int quantity;

    public Product(Long id, String name, int quantity, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public void addStock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        this.quantity += amount;
    }

    public void removeStock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (amount > this.quantity) {
            throw new IllegalStateException("Not enough stock.");
        }
        this.quantity -= amount;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Category getCategory() { return category; }
    public int getQuantity() { return quantity; }

    public void setCategory(Category category) {
        this.category = category;
    }
}
