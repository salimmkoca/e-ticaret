package com.example.payment.library.basket;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("BASKET")
public interface BasketFeignClient extends BasketFeignCallableApi {
}
