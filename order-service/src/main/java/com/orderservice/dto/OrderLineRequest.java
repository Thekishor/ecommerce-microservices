package com.orderservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderLineRequest {

    private Integer id;

    @NotNull(message = "Order Id required")
    private Integer orderId;

    @NotNull(message = "Product Id required")
    private Integer productId;

    @Positive(message = "Quantity should be greater than 0")
    private Integer quantity;
}
