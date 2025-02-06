package com.orderservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseRequest {

    @NotNull(message = "Product Id cannot be null")
    private Integer productId;

    @Positive(message = "Quantity is mandatory")
    private Integer quantity;
}