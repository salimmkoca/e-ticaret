package com.example.stock.product.api;

import com.example.stock.category.api.CategoryDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private int productId;
    private String productName;
    private double price;
    private CategoryDto categoryDto;
}
