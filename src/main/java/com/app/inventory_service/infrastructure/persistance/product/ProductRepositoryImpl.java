package com.app.inventory_service.infrastructure.persistance.product;

import com.app.inventory_service.domain.category.Category;
import com.app.inventory_service.domain.product.Product;
import com.app.inventory_service.domain.product.ProductRepository;
import com.app.inventory_service.infrastructure.persistance.category.CategoryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final SpringDataProductRepository jpaRepo;

    public ProductRepositoryImpl(SpringDataProductRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepo.findById(id).map(this::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return jpaRepo.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void save(Product product) {
        jpaRepo.save(toEntity(product));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepo.deleteById(id);
    }

    // === Mapping ===
    private Product toDomain(ProductEntity entity) {
        return new Product(
                entity.getId(),
                entity.getProductName(),
                entity.getQuantity(),
                new Category(entity.getCategory().getId(), entity.getCategory().getCategoryName())
        );
    }

    private ProductEntity toEntity(Product domain) {
        CategoryEntity categoryEntity = new CategoryEntity(
                domain.getCategory().getId(),
                domain.getCategory().getName());

        return new ProductEntity(
                domain.getId(),
                domain.getName(),
                domain.getQuantity(),
                categoryEntity);
    }

}
