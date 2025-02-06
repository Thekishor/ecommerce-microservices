package com.productservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseRequest {

    @NotNull(message = "Product id is Mandatory")
    private Integer productId;

    @Positive(message = "Available quantity must be greater than 0")
    private Integer quantity;
}
