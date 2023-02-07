package com.example.medic_kg.service.appointment;

import com.example.medic_kg.dto.AppointmentRequest;
import com.example.medic_kg.dto.CreateUpdateDeleteResponse;
import com.example.medic_kg.entity.doctor.Appointment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    public List<Appointment> getAll();

    public Optional<Appointment> findById(int id);

    public ResponseEntity<CreateUpdateDeleteResponse> add(AppointmentRequest appointmentRequest);

    public void update(Appointment appointment);

    public void delete(int id);
}
