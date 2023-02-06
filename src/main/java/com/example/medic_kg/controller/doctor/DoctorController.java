package com.example.medic_kg.controller.doctor;

import com.example.medic_kg.entity.doctor.Doctor;
import com.example.medic_kg.service.doctor.impl.DoctorServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Doctor> showAllDoctors() {
        List<Doctor> allDoctors = doctorService.getALl();

        return allDoctors;
    }

    @GetMapping("/doctor/{id}")
    public Optional<Doctor> getDoctor(@PathVariable int id) {
        Optional<Doctor> doctor = doctorService.findById(id);

        if(doctor == null) {
            throw new NoSuchElementException("There is no doctor with id: "+ id + " in DB");
        }

        return doctor;
    }

    @PostMapping("/add/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        doctorService.add(doctor);

        return doctor;
    }

    @PutMapping("/update/doctors")
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        doctorService.update(doctor);

        return doctor;
    }

    @DeleteMapping("/delete/doctor/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Optional<Doctor> doctor = doctorService.findById(id);

        if(doctor == null) {
            throw new NoSuchElementException("There is no doctor with ID = " + id + " in DataBase");
        }

        doctorService.delete(id);
        return "Doctor with ID = " + id + " was deleted";
    }
}
