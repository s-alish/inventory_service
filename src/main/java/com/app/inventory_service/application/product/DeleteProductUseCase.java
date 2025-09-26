package com.app.inventory_service.application.product;

import com.app.inventory_service.domain.product.ProductRepository;

public class DeleteProductUseCase {

    private final ProductRepository productRepository;

    public DeleteProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void execute(Long productId){
        productRepository.deleteById(productId);
    }
}
