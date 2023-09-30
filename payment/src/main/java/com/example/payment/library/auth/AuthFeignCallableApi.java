package com.example.payment.library.auth;

import com.example.payment.auth.impl.AuthResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
public interface AuthFeignCallableApi {
    @GetMapping("/users/{id}")
    AuthResponse getByUserId(@PathVariable(value ="id") String id);
}
