package com.example.basket.library;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("PRODUCT")
public interface ProductFeignClient extends ProductFeignCallableApi{
}
