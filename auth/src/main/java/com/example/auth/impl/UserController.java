package com.example.auth.impl;

import com.example.auth.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users/")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public AuthResponse register(@RequestBody UserRequest request){
        return AuthResponse.fromDto(service.register(request.toDto()));
    }
    @GetMapping("{id}")
    public AuthResponse getByUserId(@PathVariable (value ="id") String id,@RequestBody UserRequest request) {
        return AuthResponse.fromDto(service.getByUserId(id,request.toDto()));
    }
    @PostMapping("/login")
    public AuthResponse login(@RequestBody UserRequest request){
        return AuthResponse.fromDto(service.login(request.toDto()));
    }
    @PutMapping("/{id}")
    public AuthResponse update(@PathVariable(name = "id")String id,@RequestBody UserRequest request){
        return AuthResponse.fromDto(service.update(id,request.toDto()));
    }
}
