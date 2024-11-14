package com.andev.controller;

import com.andev.entity.user.UserEntity;
import com.andev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserCURDController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity userEntity){
        return userService.createUser(userEntity);
    }

@GetMapping("/search")
    public UserEntity searchUser (@RequestParam String name, @RequestParam String email) {
        return  userService.findByUserNameAndUserEmail(name, email);
    }
}