package com.app.inventory_service.application.category;

import com.app.inventory_service.domain.category.Category;
import com.app.inventory_service.domain.category.CategoryRepository;

public class CreateCategoryUseCase {

    private final CategoryRepository categoryRepository;

    public CreateCategoryUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void execute(String categoryName) {
        Category category = new Category(null, categoryName);
        categoryRepository.save(category);
    }
}
