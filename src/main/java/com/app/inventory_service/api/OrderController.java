package com.app.inventory_service.api;

import com.app.inventory_service.api.dto.OrderRequest;
import com.app.inventory_service.api.dto.OrderResponse;
import com.app.inventory_service.application.order.CreateOrderUseCase;
import com.app.inventory_service.application.order.DeleteOrderUseCase;
import com.app.inventory_service.application.order.ListOrdersUseCase;
import com.app.inventory_service.application.order.UpdateOrderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@Tag(name = "Orders", description = "Управление заказами")
public class OrderController {

    private final CreateOrderUseCase createOrder;
    private final ListOrdersUseCase listOrders;
    private final UpdateOrderUseCase updateOrder;
    private final DeleteOrderUseCase deleteOrder;

    public OrderController(CreateOrderUseCase createOrder,
                           ListOrdersUseCase listOrders,
                           UpdateOrderUseCase updateOrder,
                           DeleteOrderUseCase deleteOrder) {
        this.createOrder = createOrder;
        this.listOrders = listOrders;
        this.updateOrder = updateOrder;
        this.deleteOrder = deleteOrder;
    }

    @Operation(summary = "Get order list")
    @GetMapping
    public List<OrderResponse> getAll() {
        return listOrders.execute().stream()
                .map(o -> new  OrderResponse(o.getId(), o.getProduct().getName(),
                        o.getAmount(), o.getType(), o.getCreatedAt()))
                .collect(Collectors.toList());
    }

    @Operation(summary = "Create an order")
    @PostMapping
    public void create(@RequestBody OrderRequest request) {
        createOrder.execute(request.productId(), request.amount(), request.type());
    }

    @Operation(summary = "Update an order")
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody OrderRequest request) {
        updateOrder.execute(id, request.productId(), request.amount(), request.type());
    }

    @Operation(summary = "Delete order")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteOrder.execute(id);
    }
}