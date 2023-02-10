package com.example.medic_kg.service.appointment;

import com.example.medic_kg.dto.requests.AppointmentRequest;
import org.springframework.http.ResponseEntity;

public interface AppointmentService {

    public ResponseEntity<String> getAll();

    public ResponseEntity<String> findById(int id);

    public ResponseEntity<String> add(AppointmentRequest appointmentRequest);

    public ResponseEntity<String> update(AppointmentRequest appointmentRequest);

    public ResponseEntity<String> delete(int id);
}
