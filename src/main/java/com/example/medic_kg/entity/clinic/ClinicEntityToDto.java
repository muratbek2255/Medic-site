package com.example.medic_kg.entity.clinic;

import com.example.medic_kg.dto.requests.ClinicRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class ClinicEntityToDto {
    public ClinicRequest entityToDto(Optional<Clinic> clinic) {
        ModelMapper modelMapper = new ModelMapper();
        ClinicRequest clinicRequest = modelMapper.map(clinic, ClinicRequest.class);
        return clinicRequest;
    }

    public List<ClinicRequest> entityToDto(List<Clinic> clinics) {

        return	clinics.stream().map(x -> entityToDto(Optional.ofNullable(x))).collect(Collectors.toList());

    }
}
