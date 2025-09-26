package com.app.inventory_service.api.dto;

import com.app.inventory_service.domain.order.OrderType;

import java.time.LocalDateTime;

public class OrderResponse {
    public Long id;
    public String productName;
    public int amount;
    public OrderType type;
    public LocalDateTime createdAt;

    public OrderResponse(Long id, String productName, int amount, OrderType type, LocalDateTime createdAt) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.type = type;
        this.createdAt = createdAt;
    }
}