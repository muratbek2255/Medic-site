package com.example.medic_kg.controller;

import com.example.medic_kg.dto.requests.AppointmentDetailRequest;
import com.example.medic_kg.entity.doctor.AppointmentDetail;
import com.example.medic_kg.service.appointment.impl.AppointmentDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentDetailController {
    private final AppointmentDetailServiceImpl appointmentService;

    @Autowired
    public AppointmentDetailController(AppointmentDetailServiceImpl appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/all/appointments-details")
    public List<AppointmentDetail> showAllAppointmentsDetail() {
        return appointmentService.getAll();
    }

    @GetMapping("/appointments-details/{id}")
    public AppointmentDetail getAppointmentDetail(@PathVariable int id) {
        return appointmentService.getById(id);
    }

    @PostMapping("/appointments-detail/add")
    public ResponseEntity<String> addAppointmentDetail(@RequestBody AppointmentDetailRequest appointmentDetailRequest) {
        return appointmentService.add(appointmentDetailRequest);
    }

    @PutMapping("/appointment-detail/update")
    public ResponseEntity<String> updateAppointmentDetail(@RequestBody AppointmentDetailRequest appointmentDetailRequest) {
        return appointmentService.update(appointmentDetailRequest);
    }

    @PutMapping("/appointment-detail/delete")
    public ResponseEntity<String> deleteAppointmentDetail(@RequestBody long id) {
        return appointmentService.delete(id);
    }
}
