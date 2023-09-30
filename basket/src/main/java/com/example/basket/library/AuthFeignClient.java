package com.example.basket.library;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("AUTH")
public interface AuthFeignClient extends AuthFeignCallableApi {
}
