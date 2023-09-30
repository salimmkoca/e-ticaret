package com.example.stock.product.impl;

import com.example.stock.category.api.CategoryDto;
import com.example.stock.product.api.ProductDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
    private String productName;
    private double price;
    private int categoryId;

    public ProductDto toDto(){
        return ProductDto.builder()
                .productName(productName)
                .price(price)
                .categoryDto(CategoryDto.builder()
                        .categoryId(categoryId)
                        .build())
                .build();
    }
}
