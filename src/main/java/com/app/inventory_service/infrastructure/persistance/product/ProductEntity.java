package com.app.inventory_service.infrastructure.persistance.product;

import com.app.inventory_service.infrastructure.persistance.category.CategoryEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="product_name", nullable = false)
    private String productName;

    @Column(name = "product_quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn
    private CategoryEntity category;

    public ProductEntity() {

    }

    public ProductEntity(Long id, String productName, int quantity, CategoryEntity category) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.category = category;
    }
}
