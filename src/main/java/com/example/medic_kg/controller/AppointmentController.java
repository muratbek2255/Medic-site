package com.example.medic_kg.controller;


import com.example.medic_kg.dto.*;
import com.example.medic_kg.service.appointment.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AppointmentController {
    private final AppointmentServiceImpl appointmentService;

    @Autowired
    public AppointmentController(AppointmentServiceImpl appointmentService, APIResponse apiResponse, NoSuchUnknownResponse suchUnknownResponse) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/all/appointments")
    public List<AppointmentRequest> showAllAppointments() {
        return appointmentService.getAll();
    }

    @GetMapping("/appointment/{id}")
    public AppointmentRequest getClinic(@PathVariable int id) {
        return appointmentService.findById(id);
    }


    @PostMapping("/appointment/add")
    public ResponseEntity<CreateUpdateDeleteResponse> add(@RequestBody AppointmentRequest appointmentRequest) {
        return ResponseEntity.ok(appointmentService.add(appointmentRequest));
    }

    @PutMapping("/update/appointments")
    public ResponseEntity<CreateUpdateDeleteResponse> updateAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        return ResponseEntity.ok(appointmentService.add(appointmentRequest));
    }

    @DeleteMapping("/delete/appointment/{id}")
    public ResponseEntity<CreateUpdateDeleteResponse> deleteAppointment(@PathVariable int id) {
        return ResponseEntity.ok(appointmentService.delete(id));
    }
}
