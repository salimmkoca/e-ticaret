package com.example.payment.basket.api;

import com.example.payment.basket.impl.BasketResponse;

public interface BasketService {
    BasketResponse getByUserId(String basketId);

}
