package com.example.medic_kg.controller.doctor;

import com.example.medic_kg.dto.ClinicRequest;
import com.example.medic_kg.dto.CreateUpdateDeleteResponse;
import com.example.medic_kg.dto.DoctorRequest;
import com.example.medic_kg.entity.doctor.Doctor;
import com.example.medic_kg.service.doctor.impl.DoctorServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class DoctorController {
    @Autowired
    private final DoctorServiceImpl doctorService;


    @GetMapping("/all/doctors")
    public List<DoctorRequest> showAllDoctors() {
        return doctorService.getALl();
    }

    @GetMapping("/doctor/{id}")
    public DoctorRequest getDoctor(@PathVariable int id) {
        return doctorService.findById(id);
    }

    @PostMapping("/add/doctors")
    public ResponseEntity<CreateUpdateDeleteResponse> addDoctor(@RequestBody DoctorRequest doctorRequest) {
        return ResponseEntity.ok(doctorService.add(doctorRequest));
    }

    @PutMapping("/update/doctors")
    public ResponseEntity<CreateUpdateDeleteResponse> updateDoctor(@RequestBody DoctorRequest doctorRequest) {
        return ResponseEntity.ok(doctorService.update(doctorRequest));
    }

    @DeleteMapping("/delete/doctor/{id}")
    public ResponseEntity<CreateUpdateDeleteResponse> deleteEmployee(@PathVariable int id) {
        return ResponseEntity.ok(doctorService.delete(id));
    }
}
