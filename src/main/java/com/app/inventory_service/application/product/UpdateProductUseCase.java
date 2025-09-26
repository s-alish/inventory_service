package com.app.inventory_service.application.product;

import com.app.inventory_service.domain.category.Category;
import com.app.inventory_service.domain.category.CategoryRepository;
import com.app.inventory_service.domain.product.Product;
import com.app.inventory_service.domain.product.ProductRepository;

public class UpdateProductUseCase {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public UpdateProductUseCase(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public void execute(Long productId, int newQuantity, String newName, Long newCategoryId ) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        Category category = categoryRepository.findById(newCategoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        product = new Product(product.getId(), newName, newQuantity, category);
        productRepository.save(product);
    }
}
