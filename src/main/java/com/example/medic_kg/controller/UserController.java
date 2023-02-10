package com.example.medic_kg.controller;

import com.example.medic_kg.entity.user.User;
import com.example.medic_kg.service.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/all/users")
    public List<User> showAllUsers() {
        return userService.getALl();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        User user = userService.getById(id);
        return user;
    }
}