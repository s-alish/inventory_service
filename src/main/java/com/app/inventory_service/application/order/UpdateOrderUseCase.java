package com.app.inventory_service.application.order;

import com.app.inventory_service.domain.order.Order;
import com.app.inventory_service.domain.order.OrderRepository;
import com.app.inventory_service.domain.order.OrderType;
import com.app.inventory_service.domain.product.Product;
import com.app.inventory_service.domain.product.ProductRepository;

public class UpdateOrderUseCase {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public UpdateOrderUseCase(OrderRepository orderRepository,  ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public void execute(Long orderId, Long productId, int newAmount, OrderType newOrderType) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()->new IllegalArgumentException("Order Not Found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(()->new IllegalArgumentException("Product Not Found"));

        order = new Order(product.getId(), product, newAmount,newOrderType, null);
        orderRepository.save(order);
    }
}
