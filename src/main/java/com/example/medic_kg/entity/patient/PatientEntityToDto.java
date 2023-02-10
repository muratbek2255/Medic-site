package com.example.medic_kg.entity.patient;

import com.example.medic_kg.dto.requests.PatientRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PatientEntityToDto {
    public PatientRequest entityToDto(Patient patient) {
        ModelMapper modelMapper = new ModelMapper();
        PatientRequest patientRequest = modelMapper.map(patient, PatientRequest.class);
        return patientRequest;
    }

    public List<PatientRequest> entityToDto(List<Patient> patients) {

        return	patients.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }
}