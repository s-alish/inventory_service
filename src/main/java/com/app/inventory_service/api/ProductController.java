package com.app.inventory_service.api;

import com.app.inventory_service.api.dto.ProductRequest;
import com.app.inventory_service.api.dto.ProductResponse;
import com.app.inventory_service.application.product.CreateProductUseCase;
import com.app.inventory_service.application.product.DeleteProductUseCase;
import com.app.inventory_service.application.product.ListProductsUseCase;
import com.app.inventory_service.application.product.UpdateProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@Tag(name = "Products")
public class ProductController {

    private final CreateProductUseCase createProduct;
    private final UpdateProductUseCase updateProduct;
    private final ListProductsUseCase listProducts;
    private final DeleteProductUseCase deleteProduct;

    public ProductController(CreateProductUseCase createProduct,
                             UpdateProductUseCase updateProduct,
                             ListProductsUseCase listProducts,
                             DeleteProductUseCase deleteProduct) {
        this.createProduct = createProduct;
        this.updateProduct = updateProduct;
        this.listProducts = listProducts;
        this.deleteProduct = deleteProduct;
    }

    @Operation(summary = "Get product list")
    @GetMapping
    public List<ProductResponse> getAll() {
        return listProducts.execute().stream()
                .map(p -> new ProductResponse(p.getId(), p.getName(), p.getCategory().getName(), p.getQuantity()))
                .collect(Collectors.toList());
    }

    @Operation(summary = "Create a product")
    @PostMapping
    public void create(@RequestBody ProductRequest request) {
        createProduct.execute(request.name, request.categoryId, request.quantity);
    }

    @Operation(summary = "Update a product")
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ProductRequest request) {
        updateProduct.execute(id, request.quantity, request.name, request.categoryId);
    }

    @Operation(summary = "Delete product")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteProduct.execute(id);
    }
}
