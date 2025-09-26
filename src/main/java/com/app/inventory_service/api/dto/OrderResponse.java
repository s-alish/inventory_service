package com.app.inventory_service.api.dto;

import com.app.inventory_service.domain.order.OrderType;

import java.time.LocalDateTime;

public record OrderResponse(Long id, String productName, int amount, OrderType type, LocalDateTime createdAt){}