package com.notificationservice.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    private Integer id;

    private String name;

    private String description;

    private Long amount;

    private Integer quantity;
}
