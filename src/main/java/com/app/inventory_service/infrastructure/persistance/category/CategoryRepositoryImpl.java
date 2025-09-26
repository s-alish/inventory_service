package com.app.inventory_service.infrastructure.persistance.category;

import com.app.inventory_service.domain.category.Category;
import com.app.inventory_service.domain.category.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final SpringDataCategoryRepository jpaRepo;

    public CategoryRepositoryImpl(SpringDataCategoryRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return jpaRepo.findById(id).map(this::toDomain);
    }

    @Override
    public List<Category> findAll() {
        return jpaRepo.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Category category) {
        jpaRepo.save(toEntity(category));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepo.deleteById(id);
    }

    // === Mapping ===
    private Category toDomain(CategoryEntity entity) {
        return new Category(entity.getId(), entity.getCategoryName());
    }

    private CategoryEntity toEntity(Category domain) {
        return new CategoryEntity(domain.getId(), domain.getName());
    }
}
