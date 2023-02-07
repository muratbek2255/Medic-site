package com.example.medic_kg.dto;

import com.example.medic_kg.entity.roles.Roles;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RegisterRequest {

    private String username;
    private String email;
    private String avatar;
    private String gender;
    private Timestamp date_birthday;
    private String password;
    private Roles role;
}
