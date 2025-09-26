package com.app.inventory_service.infrastructure.persistance.order;

import com.app.inventory_service.domain.order.Order;
import com.app.inventory_service.domain.order.OrderType;
import com.app.inventory_service.infrastructure.persistance.product.ProductEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="amount", nullable = false)
    private int amount;

    @Enumerated(EnumType.STRING)
    private OrderType type;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    public OrderEntity() {}

    public OrderEntity(Long id, int amount, OrderType type, ProductEntity product) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.product = product;
    }

}
