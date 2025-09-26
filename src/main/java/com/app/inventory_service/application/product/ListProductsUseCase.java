package com.app.inventory_service.application.product;

import com.app.inventory_service.domain.product.Product;
import com.app.inventory_service.domain.product.ProductRepository;

import java.util.List;

public class ListProductsUseCase {
    private final ProductRepository productRepository;

    public ListProductsUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> execute() {
        return productRepository.findAll();
    }
}
