package com.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResponse {

    private Integer id;

    private String name;

    private String description;

    private Integer quantity;

    private Long price;

    private Integer categoryId;

    private String categoryName;

    private String categoryDescription;
}
