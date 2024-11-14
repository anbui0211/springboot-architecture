package com.andev.service;

import com.andev.entity.user.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserEntity createUser(UserEntity user);
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);
}