package com.example.medic_kg.controller.clinic;

import com.example.medic_kg.dto.requests.ClinicRequest;
import com.example.medic_kg.service.clinic.impl.ClinicServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ClinicController {

    @Autowired
    private final ClinicServiceImpl clinicService;


    @GetMapping("/all/clinics")
    public ResponseEntity<String> showAllClinics() {
        return clinicService.getALl();
    }

    @GetMapping("/clinic/{id}")
    public ResponseEntity<String> getClinic(@PathVariable int id) {
        return clinicService.getById(id);
    }

    @PostMapping("/add/clinics")
    public ResponseEntity<String> addClinic(@RequestBody ClinicRequest clinicRequest) {
        return clinicService.add(clinicRequest);
    }

    @PutMapping("/update/clinics")
    public ResponseEntity<String> updateClinic(@RequestBody ClinicRequest clinicRequest) {
        return clinicService.update(clinicRequest);
    }

    @DeleteMapping("/delete/clinic/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        return clinicService.delete(id);

    }
}
