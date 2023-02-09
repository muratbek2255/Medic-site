package com.example.medic_kg.service.patient;


import com.example.medic_kg.dto.PatientRequest;
import com.example.medic_kg.entity.user.User;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface PatientService {

    public ResponseEntity<String> getALl();
    public ResponseEntity<String> findById(int id);
    public ResponseEntity<String> add(PatientRequest patientRequest);

    public ResponseEntity<String> update(PatientRequest patientRequest, User user);

    public ResponseEntity<String> delete(int id);
}
