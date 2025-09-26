package com.app.inventory_service.api.dto;



public record ProductResponse(Long id, String name, String categoryName, int quantity){}