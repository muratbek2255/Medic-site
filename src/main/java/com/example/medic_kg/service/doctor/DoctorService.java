package com.example.medic_kg.service.doctor;

import com.example.medic_kg.dto.requests.DoctorRequest;
import com.example.medic_kg.entity.doctor.Doctor;
import org.springframework.http.ResponseEntity;

public interface DoctorService {

    public ResponseEntity<String> getALl();

    public Doctor getById(int id);

    public ResponseEntity<String> add(DoctorRequest doctorRequest);

    public ResponseEntity<String> update(DoctorRequest doctorRequest);

    public ResponseEntity<String> delete(int id);
}
