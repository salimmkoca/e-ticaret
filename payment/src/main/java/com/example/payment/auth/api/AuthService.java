package com.example.payment.auth.api;

import com.example.payment.auth.impl.AuthResponse;

public interface AuthService {
    AuthResponse getByUserId(String userId);
}
