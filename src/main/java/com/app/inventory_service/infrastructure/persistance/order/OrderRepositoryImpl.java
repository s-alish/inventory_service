package com.app.inventory_service.infrastructure.persistance.order;

import com.app.inventory_service.domain.category.Category;
import com.app.inventory_service.domain.order.Order;
import com.app.inventory_service.domain.order.OrderRepository;
import com.app.inventory_service.domain.product.Product;
import com.app.inventory_service.infrastructure.persistance.category.CategoryEntity;
import com.app.inventory_service.infrastructure.persistance.product.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final SpringDataOrderRepository jpaRepo;

    public OrderRepositoryImpl(SpringDataOrderRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return jpaRepo.findById(id).map(this::toDomain);
    }

    @Override
    public List<Order> findAll() {
        return jpaRepo.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Order order) {
        jpaRepo.save(toEntity(order));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepo.deleteById(id);
    }

    // === Mapping ===
    private Order toDomain(OrderEntity entity) {
        Category category = null;
        if (entity.getProduct().getCategory() != null) {
            category = new Category(
                    entity.getProduct().getCategory().getId(),
                    entity.getProduct().getCategory().getCategoryName()
            );
        }

        Product product = new Product(
                entity.getProduct().getId(),
                entity.getProduct().getProductName(),
                entity.getProduct().getQuantity(),
                category
        );

        return new Order(
                entity.getId(),
                product,
                entity.getAmount(),
                entity.getType(),
                entity.getCreatedAt()
        );
    }

    private OrderEntity toEntity(Order domain) {
        CategoryEntity categoryEntity = null;
        if (domain.getProduct().getCategory() != null) {
            categoryEntity = new CategoryEntity(
                    domain.getProduct().getCategory().getId(),
                    domain.getProduct().getCategory().getName()
            );
        }

        ProductEntity productEntity = new ProductEntity(
                domain.getProduct().getId(),
                domain.getProduct().getName(),
                domain.getProduct().getQuantity(),
                categoryEntity
        );

        return new OrderEntity(
                domain.getId(),
                domain.getAmount(),
                domain.getType(),
                productEntity
        );
    }
}