package com.example.medic_kg.service.patient;


import com.example.medic_kg.dto.requests.PatientRequest;
import com.example.medic_kg.entity.patient.Patient;
import org.springframework.http.ResponseEntity;


public interface PatientService {

    public ResponseEntity<String> getALl();
    public Patient getById(int id);
    public ResponseEntity<String> add(PatientRequest patientRequest);

    public ResponseEntity<String> update(PatientRequest patientRequest);

    public ResponseEntity<String> delete(int id);
}
