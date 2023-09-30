package com.example.auth.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private int userId;
    private String userName;
    private String name;
    private String surName;
    private String password;
}
