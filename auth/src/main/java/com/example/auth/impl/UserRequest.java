package com.example.auth.impl;

import com.example.auth.api.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private String userName;
    private String name;
    private String surName;
    private String password;

    public UserDto toDto(){
        return UserDto.builder()
                .userName(userName)
                .name(name)
                .surName(surName)
                .password(password)
                .build();
    }
}
