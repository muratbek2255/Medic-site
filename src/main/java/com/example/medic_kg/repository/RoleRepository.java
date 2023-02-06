package com.example.medic_kg.repository;

import com.example.medic_kg.entity.roles.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByName(String name);
}