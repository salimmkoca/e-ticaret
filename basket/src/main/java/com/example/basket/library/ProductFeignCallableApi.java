package com.example.basket.library;

import com.example.basket.product.impl.ProductResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductFeignCallableApi {
    @GetMapping("/products/{id}")
    ProductResponse getByProductId(@PathVariable(value = "id")String id);
}
