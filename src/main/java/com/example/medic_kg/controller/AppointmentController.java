package com.example.medic_kg.controller;


import com.example.medic_kg.dto.*;
import com.example.medic_kg.service.appointment.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class AppointmentController {
    private final AppointmentServiceImpl appointmentService;

    @Autowired
    public AppointmentController(AppointmentServiceImpl appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/all/appointments")
    public ResponseEntity<String> showAllAppointments() {
        return appointmentService.getAll();
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<String> getAppointment(@PathVariable int id) {
        return appointmentService.findById(id);
    }


    @PostMapping("/appointment/add/")
    public ResponseEntity<String> add(@RequestBody AppointmentRequest appointmentRequest) {
        return appointmentService.add(appointmentRequest);
    }

    @PutMapping("/update/appointments")
    public ResponseEntity<String> updateAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        return appointmentService.add(appointmentRequest);
    }

    @DeleteMapping("/delete/appointment/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable int id) {
        return appointmentService.delete(id);
    }
}
