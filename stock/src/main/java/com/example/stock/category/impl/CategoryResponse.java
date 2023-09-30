package com.example.stock.category.impl;

import com.example.stock.category.api.CategoryDto;
import com.example.stock.product.api.ProductDto;
import library.BaseResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryResponse extends BaseResponse {
    private int categoryId;
    private String categoryName;
    private List<ProductDto> productList;

    public static CategoryResponse fromDto(CategoryDto dto){
        return CategoryResponse.builder()
                .categoryId(dto.getCategoryId())
                .categoryName(dto.getCategoryName())
                .productList(dto.getProductList())
                .build();
    }
}
