package com.example.basket.product.api;

import com.example.basket.product.impl.ProductResponse;

public interface ProductService {
    ProductResponse getByProductId(String productId);

}
