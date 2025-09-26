package com.app.inventory_service.infrastructure.persistance.category;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    public CategoryEntity() {}

    public CategoryEntity(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
}
