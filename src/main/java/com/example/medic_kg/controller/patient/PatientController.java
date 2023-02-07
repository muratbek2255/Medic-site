package com.example.medic_kg.controller.patient;

import com.example.medic_kg.dto.ClinicRequest;
import com.example.medic_kg.dto.CreateUpdateDeleteResponse;
import com.example.medic_kg.dto.DoctorRequest;
import com.example.medic_kg.dto.PatientRequest;
import com.example.medic_kg.entity.patient.Patient;
import com.example.medic_kg.service.patient.impl.PatientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PatientController {
    @Autowired
    private final PatientServiceImpl patientService;


    @GetMapping("/all/patients")
    public ResponseEntity<PatientRequest> getAllPatients() {
        return ResponseEntity.ok((PatientRequest) patientService.getALl());
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<PatientRequest> getAllPatients(int id) {
        return ResponseEntity.ok((PatientRequest) patientService.findById(id));
    }


    @PostMapping("/add/patients")
    public ResponseEntity<CreateUpdateDeleteResponse> addPatient(@RequestBody PatientRequest patientRequest) {
        return ResponseEntity.ok(patientService.add(patientRequest));
    }

    @PutMapping("/update/patients")
    public ResponseEntity<CreateUpdateDeleteResponse> updatePatient(@RequestBody PatientRequest patientRequest) {
        return ResponseEntity.ok(patientService.update(patientRequest));
    }

    @DeleteMapping("/delete/patient/{id}")
    public ResponseEntity<CreateUpdateDeleteResponse> deletePatient(@PathVariable int id) {
        return ResponseEntity.ok(patientService.delete(id));
    }
}
