package com.example.medic_kg.service.user;

import com.example.medic_kg.entity.user.User;

import java.util.List;

public interface UserService {

    public List<User> getALl();
    public User getById(int id);
}
