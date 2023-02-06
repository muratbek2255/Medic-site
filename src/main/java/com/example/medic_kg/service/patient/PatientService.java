package com.example.medic_kg.service.patient;


import com.example.medic_kg.entity.patient.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    public List<Patient> getALl();

    public Optional<Patient> findById(int id);

    public void update(Patient patient);

    public void delete(int id);
}
