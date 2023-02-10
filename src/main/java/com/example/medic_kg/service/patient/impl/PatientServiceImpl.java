package com.example.medic_kg.service.patient.impl;

import com.example.medic_kg.dto.PatientRequest;
import com.example.medic_kg.entity.doctor.Doctor;
import com.example.medic_kg.entity.patient.Patient;
import com.example.medic_kg.entity.patient.PatientEntityToDto;
import com.example.medic_kg.entity.user.User;
import com.example.medic_kg.exception_handling.NoSuchUnknownException;
import com.example.medic_kg.repository.patient.PatientRepository;
import com.example.medic_kg.repository.user.UserRepository;
import com.example.medic_kg.service.patient.PatientService;
import com.example.medic_kg.service.user.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientEntityToDto patientEntityToDto;

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, PatientEntityToDto patientEntityToDto, UserRepository userRepository, UserService userService) {
        this.patientRepository = patientRepository;
        this.patientEntityToDto = patientEntityToDto;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public ResponseEntity<String> getALl() {
        List<Patient> patients = patientRepository.findAll();
        patientEntityToDto.entityToDto(patients);

        return ResponseEntity.status(200).body("All patients!");
    }

    @Override
    public Patient getById(int id) {
        Patient patient= patientRepository.getById(id);
        return patient;
    }

    @Override
    public ResponseEntity<String> add(PatientRequest patientRequest) {
        Patient patient = new Patient();
        User user = userService.getById(patientRequest.getUser().getId());
        patient.setBloodType(patientRequest.getBloodType());
        patient.setInfo(patientRequest.getInfo());
        patient.setAddress(patientRequest.getAddress());
        patient.setUser(user);

        patientRepository.save(patient);

        return ResponseEntity.status(201).body("Created patient");
    }

    @Override
    public ResponseEntity<String> update(PatientRequest patientRequest) {
        Patient patient = new Patient();
        User user = userService.getById(patientRequest.getUser().getId());
        patient.setBloodType(patientRequest.getBloodType());
        patient.setInfo(patientRequest.getInfo());
        patient.setAddress(patientRequest.getAddress());
        patient.setUser(user);

        patientRepository.save(patient);

        return ResponseEntity.status(201).body("Created patient");
    }

    @Override
    public ResponseEntity<String> delete(int id) {
        patientRepository.deleteById(id);

        return ResponseEntity.status(202).body("Deleted patient");
    }
}
