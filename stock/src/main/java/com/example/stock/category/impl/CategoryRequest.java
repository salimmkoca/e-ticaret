package com.example.stock.category.impl;

import com.example.stock.category.api.CategoryDto;
import com.example.stock.product.api.ProductDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryRequest {
    private String categoryName;
    private List<ProductDto>productList;

    public CategoryDto toDto(){
        return CategoryDto.builder()
                .categoryName(categoryName)
                .productList(productList)
                .build();
    }
}
