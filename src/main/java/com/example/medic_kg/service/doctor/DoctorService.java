package com.example.medic_kg.service.doctor;

import com.example.medic_kg.dto.DoctorRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DoctorService {

    public ResponseEntity<String> getALl();

    public ResponseEntity<String> findById(int id);

    public ResponseEntity<String> add(DoctorRequest doctorRequest);

    public ResponseEntity<String> update(DoctorRequest doctorRequest);

    public ResponseEntity<String> delete(int id);
}
