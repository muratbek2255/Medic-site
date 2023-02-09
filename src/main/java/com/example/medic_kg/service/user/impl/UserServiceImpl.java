package com.example.medic_kg.service.user.impl;

import com.example.medic_kg.entity.user.User;
import com.example.medic_kg.repository.user.UserRepository;
import com.example.medic_kg.service.user.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getALl() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        User user = userRepository.findById(id);
        return user;
    }
}
