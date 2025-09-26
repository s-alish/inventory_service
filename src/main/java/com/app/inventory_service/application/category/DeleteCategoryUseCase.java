package com.app.inventory_service.application.category;

import com.app.inventory_service.domain.category.CategoryRepository;

public class DeleteCategoryUseCase {

    private final CategoryRepository categoryRepository;

    public DeleteCategoryUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void execute(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }
}
