package com.app.inventory_service.api.dto;

public class CategoryResponse {
    public Long id;
    public String name;

    public CategoryResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}