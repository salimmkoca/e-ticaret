package com.example.payment.library.auth;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("AUTH")
public interface AuthFeignClient extends AuthFeignCallableApi {
}
