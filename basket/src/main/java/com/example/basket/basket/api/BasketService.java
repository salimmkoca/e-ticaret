package com.example.basket.basket.api;

public interface BasketService {
    BasketDto add(BasketDto dto);
    BasketDto find(String id, BasketDto dto);

    void delete(String id, BasketDto dto);

    BasketDto findBasketByUser(String id, BasketDto dto);
}
