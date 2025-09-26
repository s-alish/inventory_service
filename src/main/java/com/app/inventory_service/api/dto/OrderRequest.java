package com.app.inventory_service.api.dto;

import com.app.inventory_service.domain.order.OrderType;

public record OrderRequest(Long productId, int amount, OrderType type){}