package com.example.medic_kg.controller.clinic;

import com.example.medic_kg.entity.clinic.Clinic;
import com.example.medic_kg.service.clinic.impl.ClinicServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Clinic> showAllClinics() {
        List<Clinic> allClinics = clinicService.getALl();

        return allClinics;
    }

    @GetMapping("/clinic/{id}")
    public Optional<Clinic> getClinic(@PathVariable int id) {
        Optional<Clinic> clinic = clinicService.findById(id);

        if(clinic == null) {
            throw new NoSuchElementException("There is no clinic with id: "+ id + " in DB");
        }

        return clinic;
    }

    @PostMapping("/add/clinics")
    public Clinic addClinic(@RequestBody Clinic clinic) {
        clinicService.add(clinic);

        return clinic;
    }

    @PutMapping("/update/clinics")
    public Clinic updateClinic(@RequestBody Clinic clinic) {
        clinicService.update(clinic);

        return clinic;
    }

    @DeleteMapping("/delete/clinic/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Optional<Clinic> clinic = clinicService.findById(id);

        if(clinic == null) {
            throw new NoSuchElementException("There is no clinic with ID = " + id + " in DataBase");
        }

        clinicService.delete(id);
        return "Clinic with ID = " + id + " was deleted";
    }
}
