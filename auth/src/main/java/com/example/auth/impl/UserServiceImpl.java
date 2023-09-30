package com.example.auth.impl;

import com.example.auth.api.UserDto;
import com.example.auth.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public UserDto register(UserDto dto) {
        return toDto(repository.save(toEntity(new User(),dto)));
    }

    @Override
    public UserDto getByUserId(String id, UserDto dto) {
        return toDto(repository.findUserByUserId(Integer.parseInt(id)));
    }

    @Override
    public UserDto login(UserDto dto) {
        return toDto(repository.findUserByUserNameEqualsAndPasswordEquals(dto.getUserName(), dto.getPassword()));
    }

    @Override
    public UserDto update(String id, UserDto dto) {
        return repository.findById(Integer.parseInt(id))
                .map(user -> toEntity(user,dto))
                .map(repository::save)
                .map(this::toDto)
                .orElseThrow(() -> new EntityNotFoundException("User bulunamadı"));
    }


    private UserDto toDto(User user){
        return UserDto.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .name(user.getName())
                .surName(user.getSurName())
                .password(user.getPassword())
                .build();
    }
    private User toEntity (User user, UserDto dto){
        user.setUserName(dto.getUserName());
        user.setName(dto.getName());
        user.setSurName(dto.getSurName());
        user.setPassword(dto.getPassword());
        return user;
    }
}
