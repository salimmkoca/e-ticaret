package com.example.basket.auth.impl;

import com.example.basket.auth.api.AuthService;
import com.example.basket.library.AuthFeignCallableApi;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthFeignCallableApi callableApi;

    public AuthServiceImpl(AuthFeignCallableApi callableApi) {
        this.callableApi = callableApi;
    }

    @Override
    public AuthResponse getByUserId(String userId){
        return callableApi.getByUserId(userId);
    }
}
