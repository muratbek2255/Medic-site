package com.example.medic_kg.entity.doctor;

import com.example.medic_kg.dto.DoctorRequest;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorEntityToDto {
    public DoctorRequest entityToDto(Doctor doctor) {
        ModelMapper modelMapper = new ModelMapper();
        DoctorRequest doctorRequest = modelMapper.map(doctor, DoctorRequest.class);
        return doctorRequest;
    }

    public List<DoctorRequest> entityToDto(List<Doctor> doctors) {

        return	doctors.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }
}