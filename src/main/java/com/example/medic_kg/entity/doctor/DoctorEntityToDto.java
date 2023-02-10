package com.example.medic_kg.entity.doctor;

import com.example.medic_kg.dto.requests.DoctorRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
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