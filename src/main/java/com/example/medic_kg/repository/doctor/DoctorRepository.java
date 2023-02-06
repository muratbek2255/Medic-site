package com.example.medic_kg.repository.doctor;

import com.example.medic_kg.entity.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
