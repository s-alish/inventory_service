package com.app.inventory_service.api.dto;

import com.app.inventory_service.domain.order.OrderType;

public class OrderRequest {
    public Long productId;
    public int amount;
    public OrderType type;
}
