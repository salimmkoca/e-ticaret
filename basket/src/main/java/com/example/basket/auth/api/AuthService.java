package com.example.basket.auth.api;

import com.example.basket.auth.impl.AuthResponse;

public interface AuthService {
    AuthResponse getByUserId(String userId);
}
