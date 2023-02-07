package com.example.medic_kg.controller.clinic;

import com.example.medic_kg.dto.ClinicRequest;
import com.example.medic_kg.dto.CreateUpdateDeleteResponse;
import com.example.medic_kg.entity.clinic.Clinic;
import com.example.medic_kg.service.clinic.impl.ClinicServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ClinicController {

    @Autowired
    private final ClinicServiceImpl clinicService;


    @GetMapping("/all/clinics")
    public List<ClinicRequest> showAllClinics() {
        return clinicService.getALl();
    }

    @GetMapping("/clinic/{id}")
    public ClinicRequest getClinic(@PathVariable int id) {
        return clinicService.findById(id);
    }

    @PostMapping("/add/clinics")
    public ResponseEntity<CreateUpdateDeleteResponse> addClinic(@RequestBody ClinicRequest clinicRequest) {
        return ResponseEntity.ok(clinicService.add(clinicRequest));
    }

    @PutMapping("/update/clinics")
    public ResponseEntity<CreateUpdateDeleteResponse> updateClinic(@RequestBody ClinicRequest clinicRequest) {
        return ResponseEntity.ok(clinicService.update(clinicRequest));
    }

    @DeleteMapping("/delete/clinic/{id}")
    public ResponseEntity<CreateUpdateDeleteResponse> deleteEmployee(@PathVariable int id) {
        return ResponseEntity.ok(clinicService.delete(id));

    }
}
