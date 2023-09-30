package com.example.payment.basket.impl;

import com.example.payment.basket.api.BasketService;
import com.example.payment.library.basket.BasketFeignCallableApi;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {
    private final BasketFeignCallableApi callableApi;

    public BasketServiceImpl(BasketFeignCallableApi callableApi){
        this.callableApi=callableApi;
    }

    @Override
    public BasketResponse getByUserId(String basketId) {
        return callableApi.getByBasketId(basketId);
    }
}
