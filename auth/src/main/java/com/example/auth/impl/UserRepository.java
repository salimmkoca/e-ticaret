package com.example.auth.impl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findUserByUserNameEqualsAndPasswordEquals(String userName,String password);
    public User findUserByUserId(Integer id);
}
