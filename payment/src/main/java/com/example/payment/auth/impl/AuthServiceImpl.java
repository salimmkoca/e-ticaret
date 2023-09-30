package com.example.payment.auth.impl;

import com.example.payment.auth.api.AuthService;
import com.example.payment.library.auth.AuthFeignCallableApi;
import org.springframework.stereotype.Service;
@Service
public class AuthServiceImpl implements AuthService {
    private final AuthFeignCallableApi callableApi;

    public AuthServiceImpl(AuthFeignCallableApi callableApi){
        this.callableApi=callableApi;
    }
    @Override
    public AuthResponse getByUserId(String userId) {
        return callableApi.getByUserId(userId);
    }
}
