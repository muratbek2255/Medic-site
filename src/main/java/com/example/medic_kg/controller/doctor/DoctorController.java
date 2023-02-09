package com.example.medic_kg.controller.doctor;

import com.example.medic_kg.dto.DoctorRequest;
import com.example.medic_kg.service.doctor.impl.DoctorServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DoctorController {
    @Autowired
    private final DoctorServiceImpl doctorService;


    @GetMapping("/all/doctors")
    public ResponseEntity<String> showAllDoctors() {
        return doctorService.getALl();
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<String> getDoctor(@PathVariable int id) {
        return doctorService.findById(id);
    }

    @PostMapping("/add/doctors")
    public ResponseEntity<String> addDoctor(@RequestBody DoctorRequest doctorRequest) {
        return doctorService.add(doctorRequest);
    }

    @PutMapping("/update/doctors")
    public ResponseEntity<String> updateDoctor(@RequestBody DoctorRequest doctorRequest) {
        return doctorService.update(doctorRequest);
    }

    @DeleteMapping("/delete/doctor/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        return doctorService.delete(id);
    }
}
