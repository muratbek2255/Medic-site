package com.example.medic_kg.controller.patient;

import com.example.medic_kg.entity.patient.Patient;
import com.example.medic_kg.service.patient.impl.PatientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Patient> showAllPatients() {
        List<Patient> allPatients = patientService.getALl();

        return allPatients;
    }

    @GetMapping("/patient/{id}")
    public Optional<Patient> getPatient(@PathVariable int id) {
        Optional<Patient> patient = patientService.findById(id);

        if(patient == null) {
            throw new NoSuchElementException("There is no patient with id: "+ id + " in DB");
        }

        return patient;
    }


    @PutMapping("/update/patients")
    public Patient updatePatient(@RequestBody Patient patient) {
        patientService.update(patient);

        return patient;
    }

    @DeleteMapping("/delete/patient/{id}")
    public String deletePatient(@PathVariable int id) {
        Optional<Patient> patient = patientService.findById(id);

        if(patient == null) {
            throw new NoSuchElementException("There is patient with ID = " + id + " in DataBase");
        }

        patientService.delete(id);
        return "Patient with ID = " + id + " was deleted";
    }
}
