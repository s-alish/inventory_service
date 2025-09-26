package com.app.inventory_service.application.category;

import com.app.inventory_service.domain.category.Category;
import com.app.inventory_service.domain.category.CategoryRepository;

public class UpdateCategoryUseCase {

    private final CategoryRepository categoryRepository;

    public UpdateCategoryUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void execute(Long categoryId, String newName) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new IllegalArgumentException("Category not found"));

        category = new Category(category.getId(), newName);
        categoryRepository.save(category);
    }
}
