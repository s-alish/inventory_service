package com.app.inventory_service.application.category;

import com.app.inventory_service.domain.category.Category;
import com.app.inventory_service.domain.category.CategoryRepository;

import java.util.List;

public class ListCategoriesUseCase {

    private final CategoryRepository categoryRepository;

    public ListCategoriesUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> execute() {
        return categoryRepository.findAll();
    }
}
