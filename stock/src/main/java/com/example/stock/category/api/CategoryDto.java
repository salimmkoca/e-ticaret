package com.example.stock.category.api;

import com.example.stock.product.api.ProductDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {
    private int categoryId;
    private String categoryName;
    private List<ProductDto>productList;
}
