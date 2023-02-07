package com.example.medic_kg.entity.doctor;

import com.example.medic_kg.dto.AppointmentRequest;
import com.example.medic_kg.dto.DoctorRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppointmentEntityToDto {
    public AppointmentRequest entityToDto(Appointment appointment) {
        ModelMapper modelMapper = new ModelMapper();
        AppointmentRequest appointmentRequest = modelMapper.map(appointment, AppointmentRequest.class);
        return appointmentRequest;
    }

    public List<AppointmentRequest> entityToDto(List<Appointment> appointments) {

        return	appointments.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }
}
