package com.example.auth.api;
public interface UserService {

    UserDto register(UserDto dto);

    UserDto getByUserId(String id, UserDto dto);

    UserDto login(UserDto dto);


    UserDto update(String id, UserDto dto);
}
