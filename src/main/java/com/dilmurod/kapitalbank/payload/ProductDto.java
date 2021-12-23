package com.dilmurod.kapitalbank.payload;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private String description;
    private double price;

    private Integer categoryId;
}
