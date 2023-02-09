package com.example.medic_kg.service.appointment;

import com.example.medic_kg.dto.AppointmentRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppointmentService {

    public ResponseEntity<String> getAll();

    public ResponseEntity<String> findById(int id);

    public ResponseEntity<String> add(AppointmentRequest appointmentRequest);

    public ResponseEntity<String> update(AppointmentRequest appointmentRequest);

    public ResponseEntity<String> delete(int id);
}
