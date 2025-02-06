package com.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequest {

    private Integer id;

    @NotBlank(message = "Product name cannot be null")
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Product description cannot be null")
    @Size(min = 5, max = 100, message = "Product description must be between 5 and 100 characters")
    private String description;

    @Positive(message = "Available quantity must be greater than 0")
    private Integer quantity;

    @Positive(message = "Price must be greater than 0")
    private Long price;

    @Positive(message = "Category Id must be positive")
    private Integer categoryId;
}
