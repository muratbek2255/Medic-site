package com.example.medic_kg.controller;


import com.example.medic_kg.dto.*;
import com.example.medic_kg.entity.doctor.Appointment;
import com.example.medic_kg.service.appointment.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
public class AppointmentController {
    private AppointmentServiceImpl appointmentService;
    private APIResponse apiResponse;

    private Appointment appointment;

    private NoSuchUnknownResponse suchUnknownResponse;

    @Autowired
    public AppointmentController(AppointmentServiceImpl appointmentService, APIResponse apiResponse, NoSuchUnknownResponse suchUnknownResponse) {
        this.appointmentService = appointmentService;
        this.apiResponse = apiResponse;
        this.suchUnknownResponse = suchUnknownResponse;
    }

    @GetMapping("/all/appointments")
    public List<Appointment> showAllAppointments() {
        List<Appointment> allAppointments = appointmentService.getAll();

        return allAppointments;
    }

    @GetMapping("/appointment/{id}")
    public Optional<Appointment> getClinic(@PathVariable int id) {
        Optional<Appointment> appointment1 = appointmentService.findById(id);

        if(appointment1 == null) {
            throw new NoSuchElementException("There is no appointment with id: "+ id + " in DB");
        }

        return appointment1;
    }


    @PostMapping("/appointment/add")
    public ResponseEntity<CreateUpdateDeleteResponse> add(@RequestBody AppointmentRequest appointmentRequest) {
        return appointmentService.add(appointmentRequest);
    }

    @PutMapping("/update/appointments")
    public Appointment updateAppointment(@RequestBody Appointment appointment) {
        appointmentService.update(appointment);

        return appointment;
    }

    @DeleteMapping("/delete/appointment/{id}")
    public String deleteAppointment(@PathVariable int id) {
        Optional<Appointment> appointment1 = appointmentService.findById(id);

        if(appointment1== null) {
            throw new NoSuchElementException("There is no appointment with ID = " + id + " in DataBase");
        }

        appointmentService.delete(id);
        return "Appointment with ID = " + id + " was deleted";
    }
}
