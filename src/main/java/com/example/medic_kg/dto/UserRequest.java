package com.example.medic_kg.dto;

import com.example.medic_kg.entity.enums.user.Gender;
import com.example.medic_kg.entity.roles.Roles;
import com.example.medic_kg.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserRequest extends User {
    private String username;
    private String email;
    private String avatar;
    private Gender gender;
    private Timestamp date_birthday;
    private String password;
    private Roles role;
    private Boolean locked = false;
    private Boolean enabled = false;
}
