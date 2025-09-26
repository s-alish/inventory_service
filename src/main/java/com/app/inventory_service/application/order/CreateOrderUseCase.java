package com.app.inventory_service.application.order;

import com.app.inventory_service.domain.order.Order;
import com.app.inventory_service.domain.order.OrderRepository;
import com.app.inventory_service.domain.order.OrderType;
import com.app.inventory_service.domain.product.Product;
import com.app.inventory_service.domain.product.ProductRepository;

import java.time.LocalDateTime;

public class CreateOrderUseCase {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public CreateOrderUseCase(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public void execute(Long productId, int amount, OrderType type) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        if (type == OrderType.IN) {
            product.addStock(amount);
        } else if (type == OrderType.OUT) {
            product.removeStock(amount);
        }

        productRepository.save(product);

        Order order = new Order(null, product, amount, type, LocalDateTime.now());
        orderRepository.save(order);
    }
}