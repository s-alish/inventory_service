package com.app.inventory_service.application.product;

import com.app.inventory_service.domain.category.Category;
import com.app.inventory_service.domain.category.CategoryRepository;
import com.app.inventory_service.domain.product.Product;
import com.app.inventory_service.domain.product.ProductRepository;

public class CreateProductUseCase {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public CreateProductUseCase(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public void execute(String name, Long categoryId, int quantity) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        Product product = new Product(null, name, quantity, category);
        productRepository.save(product);
    }
}
