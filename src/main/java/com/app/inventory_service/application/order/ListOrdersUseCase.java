package com.app.inventory_service.application.order;

import com.app.inventory_service.domain.order.Order;
import com.app.inventory_service.domain.order.OrderRepository;

import java.util.List;

public class ListOrdersUseCase {

    private final OrderRepository orderRepository;

    public ListOrdersUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> execute() {
        return orderRepository.findAll();
    }
}