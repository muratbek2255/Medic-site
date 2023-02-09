package com.example.medic_kg.service.user;

import com.example.medic_kg.dto.PatientRequest;
import com.example.medic_kg.entity.user.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getALl();
    public User findById(int id);
}
