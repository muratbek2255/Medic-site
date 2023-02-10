package com.example.medic_kg.service.clinic;

import com.example.medic_kg.dto.ClinicRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClinicService {

    public ResponseEntity<String> getALl();

    public ResponseEntity<String> getById(int id);

    public ResponseEntity<String> add(ClinicRequest clinicRequest);

    public ResponseEntity<String> update(ClinicRequest clinic);

    public ResponseEntity<String> delete(int id);
}
