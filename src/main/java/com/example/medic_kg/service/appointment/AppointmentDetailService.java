package com.example.medic_kg.service.appointment;

import com.example.medic_kg.dto.requests.AppointmentDetailRequest;
import com.example.medic_kg.entity.doctor.AppointmentDetail;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppointmentDetailService {
    public List<AppointmentDetail> getAll();

    public AppointmentDetail getById(long id);

    public ResponseEntity<String> add(AppointmentDetailRequest appointmentRequest);

    public ResponseEntity<String> update(AppointmentDetailRequest appointmentRequest);

    public ResponseEntity<String> delete(long id);
}
