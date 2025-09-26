package com.app.inventory_service.api.dto;


public record ProductRequest(String name, Long categoryId, int quantity){}