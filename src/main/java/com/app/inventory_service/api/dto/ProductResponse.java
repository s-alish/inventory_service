package com.app.inventory_service.api.dto;

public class ProductResponse {
    public Long id;
    public String name;
    public String categoryName;
    public int quantity;

    public ProductResponse(Long id, String name, String categoryName, int quantity) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.quantity = quantity;
    }
}