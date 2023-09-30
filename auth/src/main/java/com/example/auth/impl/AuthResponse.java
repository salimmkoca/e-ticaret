package com.example.auth.impl;

import com.example.auth.api.UserDto;
import library.BaseResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse extends BaseResponse {
   private int userId;
   private String userName;
   private String name;
   private String surName;
   private String password;

   public static AuthResponse fromDto(UserDto dto){
      return AuthResponse.builder()
              .userId(dto.getUserId())
              .userName(dto.getUserName())
              .name(dto.getName())
              .surName(dto.getSurName())
              .password(dto.getPassword())
              .build();
   }
}
