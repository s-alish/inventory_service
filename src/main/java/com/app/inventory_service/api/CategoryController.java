package com.app.inventory_service.api;

import com.app.inventory_service.api.dto.CategoryRequest;
import com.app.inventory_service.api.dto.CategoryResponse;
import com.app.inventory_service.application.category.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
@Tag(name = "Categories", description = "Управление категориями")
public class CategoryController {

    private final CreateCategoryUseCase createCategory;
    private final ListCategoriesUseCase listCategories;
    private final UpdateCategoryUseCase updateCategory;
    private final DeleteCategoryUseCase deleteCategory;

    public CategoryController(CreateCategoryUseCase createCategory,
                              ListCategoriesUseCase listCategories,
                              UpdateCategoryUseCase updateCategory,
                              DeleteCategoryUseCase deleteCategory) {
        this.createCategory = createCategory;
        this.listCategories = listCategories;
        this.updateCategory = updateCategory;
        this.deleteCategory = deleteCategory;
    }

    @Operation(summary = "Get category list")
    @GetMapping
    public List<CategoryResponse> getAll() {
        return listCategories.execute().stream()
                .map(c -> new CategoryResponse(c.getId(), c.getName()))
                .collect(Collectors.toList());
    }

    @Operation(summary = "Create a category")
    @PostMapping
    public void create(@RequestBody CategoryRequest request) {
        createCategory.execute(request.name());
    }

    @Operation(summary = "Update a category")
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CategoryRequest request) {
        updateCategory.execute(id, request.name());
    }

    @Operation(summary = "Delete category")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteCategory.execute(id);
    }
}
