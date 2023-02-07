package com.example.medic_kg.service.appointment;

import com.example.medic_kg.dto.AppointmentRequest;
import com.example.medic_kg.dto.CreateUpdateDeleteResponse;
import com.example.medic_kg.entity.doctor.Appointment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    public List<AppointmentRequest> getAll();

    public AppointmentRequest findById(int id);

    public CreateUpdateDeleteResponse add(AppointmentRequest appointmentRequest);

    public CreateUpdateDeleteResponse update(AppointmentRequest appointmentRequest);

    public CreateUpdateDeleteResponse delete(int id);
}
