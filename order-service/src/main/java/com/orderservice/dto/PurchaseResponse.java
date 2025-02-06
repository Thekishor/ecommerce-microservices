package com.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseResponse {

    private Integer productId;

    private String name;

    private String description;

    private Long price;

    private Integer quantity;
}
