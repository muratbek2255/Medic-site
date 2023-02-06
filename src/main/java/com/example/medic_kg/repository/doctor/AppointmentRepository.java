package com.example.medic_kg.repository.doctor;

import com.example.medic_kg.entity.doctor.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
