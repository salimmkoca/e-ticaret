package com.example.basket.product.impl;

import com.example.basket.library.ProductFeignCallableApi;
import com.example.basket.product.api.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductFeignCallableApi callableApi;
    public ProductServiceImpl(ProductFeignCallableApi callableApi){
        this.callableApi=callableApi;
    }
    @Override
    public ProductResponse getByProductId(String productId) {
        return null;
    }
}
