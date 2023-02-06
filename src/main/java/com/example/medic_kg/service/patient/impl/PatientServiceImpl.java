package com.example.medic_kg.service.patient.impl;

import com.example.medic_kg.entity.patient.Patient;
import com.example.medic_kg.repository.patient.PatientRepository;
import com.example.medic_kg.service.patient.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    @Autowired
    private final PatientRepository patientRepository;


    @Override
    public List<Patient> getALl() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findById(int id) {
        return patientRepository.findById(id);
    }

    @Override
    public void update(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void delete(int id) {
        patientRepository.deleteById(id);
    }
}
