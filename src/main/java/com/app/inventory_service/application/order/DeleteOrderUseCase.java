package com.app.inventory_service.application.order;

import com.app.inventory_service.domain.order.OrderRepository;

public class DeleteOrderUseCase {

    private final OrderRepository orderRepository;

    public DeleteOrderUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void execute(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}