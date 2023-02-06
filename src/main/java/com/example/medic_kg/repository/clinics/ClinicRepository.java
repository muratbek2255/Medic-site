package com.example.medic_kg.repository.clinics;

import com.example.medic_kg.entity.clinic.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
    Clinic findByFullName(String fullName);
}
