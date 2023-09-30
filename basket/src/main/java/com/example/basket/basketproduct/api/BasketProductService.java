package com.example.basket.basketproduct.api;

import com.example.basket.basketproduct.impl.BasketProduct;

import java.util.List;

public interface BasketProductService {
    List<BasketProductDto>toDtoList(List<BasketProduct>basketProducts);
    BasketProductDto find(String id);
    void delete(String id);
}
