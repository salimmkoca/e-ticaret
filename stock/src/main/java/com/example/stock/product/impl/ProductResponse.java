package com.example.stock.product.impl;

import com.example.stock.category.api.CategoryDto;
import com.example.stock.product.api.ProductDto;
import library.BaseResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse extends BaseResponse {
    private int productId;
    private String productName;
    private double price;
    private CategoryDto categoryDto;

    public static ProductResponse fromDto(ProductDto productDto){
        return ProductResponse.builder()
                .productId(productDto.getProductId())
                .productName(productDto.getProductName())
                .price(productDto.getPrice())
                .categoryDto(CategoryDto.builder()
                        .categoryId(productDto.getCategoryDto().getCategoryId())
                        .categoryName(productDto.getCategoryDto().getCategoryName())
                        .build())
                .build();
    }
}
