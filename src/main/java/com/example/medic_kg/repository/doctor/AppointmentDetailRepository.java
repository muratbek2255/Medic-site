package com.example.medic_kg.repository.doctor;

import com.example.medic_kg.entity.doctor.AppointmentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentDetailRepository extends JpaRepository<AppointmentDetail, Long> {
}
