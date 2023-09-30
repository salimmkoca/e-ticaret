package com.example.payment.library.basket;

import com.example.payment.basket.impl.BasketResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface BasketFeignCallableApi {
    @GetMapping("/baskets/{id}")
    BasketResponse getByBasketId(@PathVariable (value = "id")String id);
}
