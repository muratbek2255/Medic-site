package com.example.medic_kg.service.patient.impl;

import com.example.medic_kg.dto.CreateUpdateDeleteResponse;
import com.example.medic_kg.dto.DoctorRequest;
import com.example.medic_kg.dto.PatientRequest;
import com.example.medic_kg.entity.patient.Patient;
import com.example.medic_kg.entity.patient.PatientEntityToDto;
import com.example.medic_kg.repository.patient.PatientRepository;
import com.example.medic_kg.service.patient.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    @Autowired
    private final PatientRepository patientRepository;
    private final PatientEntityToDto patientEntityToDto;

    @Override
    public List<PatientRequest> getALl() {
        List<Patient> patients = patientRepository.findAll();
        return patientEntityToDto.entityToDto(patients);
    }

    @Override
    public PatientRequest findById(int id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        return patientEntityToDto.entityToDto(patient);
    }

    @Override
    public CreateUpdateDeleteResponse add(PatientRequest patientRequest) {
        var patient = Patient.builder()
                .bloodType(patientRequest.getBloodType())
                .info(patientRequest.getInfo())
                .address(patientRequest.getAddress())
                .user(patientRequest.getUser())
                .build();

        patientRepository.save(patient);

        return CreateUpdateDeleteResponse.builder()
                .msg("Patient created!!!")
                .build();
    }

    @Override
    public CreateUpdateDeleteResponse update(PatientRequest patientRequest) {
        var patient = Patient.builder()
                .bloodType(patientRequest.getBloodType())
                .info(patientRequest.getInfo())
                .address(patientRequest.getAddress())
                .user(patientRequest.getUser())
                .build();

        patientRepository.save(patient);

        return CreateUpdateDeleteResponse.builder()
                .msg("Patient updated!!!")
                .build();
    }

    @Override
    public CreateUpdateDeleteResponse delete(int id) {
        patientRepository.deleteById(id);

        return CreateUpdateDeleteResponse.builder()
                .msg("Patient deleted!!!")
                .build();
    }
}
