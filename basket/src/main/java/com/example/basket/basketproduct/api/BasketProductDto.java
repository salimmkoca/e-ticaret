package com.example.basket.basketproduct.api;

import com.example.basket.product.api.ProductDto;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class BasketProductDto {
    private int basketProductId;
    private ProductDto product;
    private int count;
    private String productName;
    private double price;
    private int productId;
}
