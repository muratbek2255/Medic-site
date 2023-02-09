package com.example.medic_kg.controller.patient;

import com.example.medic_kg.dto.PatientRequest;
import com.example.medic_kg.entity.user.User;
import com.example.medic_kg.repository.user.UserRepository;
import com.example.medic_kg.service.patient.impl.PatientServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PatientController {
    @Autowired
    private final PatientServiceImpl patientService;

    private final UserRepository userRepository;


    @GetMapping("/all/patients")
    public ResponseEntity<String> getAllPatients() {
        return patientService.getALl();
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<String> getAllPatients(int id) {
        return patientService.findById(id);
    }


    @PostMapping("/add/patients")
    public ResponseEntity<String> addPatient(@RequestBody PatientRequest patientRequest) {
        System.out.println(patientRequest);
        return patientService.add(patientRequest);
    }

    @PutMapping("/update/patients")
    public ResponseEntity<String> updatePatient(@RequestBody PatientRequest patientRequest) {
        User user = userRepository.findById(patientRequest.getUser().getId())
                .orElseThrow(EntityNotFoundException::new);
        return patientService.update(patientRequest, user);
    }

    @DeleteMapping("/delete/patient/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id) {
        return patientService.delete(id);
    }
}
