package com.app.inventory_service.infrastructure.config;

import com.app.inventory_service.application.product.*;
import com.app.inventory_service.application.category.*;
import com.app.inventory_service.application.order.*;

import com.app.inventory_service.domain.category.CategoryRepository;
import com.app.inventory_service.domain.order.OrderRepository;
import com.app.inventory_service.domain.product.ProductRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    // === Product use cases ===
    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepository productRepository,
                                                     CategoryRepository categoryRepository) {
        return new CreateProductUseCase(productRepository, categoryRepository);
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase(ProductRepository productRepository,
                                                     CategoryRepository categoryRepository) {
        return new UpdateProductUseCase(productRepository, categoryRepository);
    }

    @Bean
    public ListProductsUseCase listProductsUseCase(ProductRepository productRepository) {
        return new ListProductsUseCase(productRepository);
    }

    @Bean
    public DeleteProductUseCase deleteProductUseCase(ProductRepository productRepository) {
        return new DeleteProductUseCase(productRepository);
    }

    // === Category use cases ===
    @Bean
    public CreateCategoryUseCase createCategoryUseCase(CategoryRepository categoryRepository) {
        return new CreateCategoryUseCase(categoryRepository);
    }

    @Bean
    public ListCategoriesUseCase listCategoriesUseCase(CategoryRepository categoryRepository) {
        return new ListCategoriesUseCase(categoryRepository);
    }

    @Bean
    public UpdateCategoryUseCase updateCategoryUseCase(CategoryRepository categoryRepository) {
        return new UpdateCategoryUseCase(categoryRepository);
    }

    @Bean
    public DeleteCategoryUseCase deleteCategoryUseCase(CategoryRepository categoryRepository) {
        return new DeleteCategoryUseCase(categoryRepository);
    }

    // === Order use cases ===
    @Bean
    public CreateOrderUseCase createOrderUseCase(ProductRepository productRepository,
                                                 OrderRepository orderRepository) {
        return new CreateOrderUseCase(productRepository, orderRepository);
    }

    @Bean
    public ListOrdersUseCase listOrdersUseCase(OrderRepository orderRepository) {
        return new ListOrdersUseCase(orderRepository);
    }

    @Bean
    public UpdateOrderUseCase updateOrderUseCase(OrderRepository orderRepository, ProductRepository productRepository) {
        return new UpdateOrderUseCase(orderRepository, productRepository);
    }

    @Bean
    public DeleteOrderUseCase deleteOrderUseCase(OrderRepository orderRepository) {
        return new DeleteOrderUseCase(orderRepository);
    }
}