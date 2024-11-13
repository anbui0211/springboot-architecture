package com.andev.service;

import com.andev.entity.user.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);
    List<UserEntity> getAllUsers();
}