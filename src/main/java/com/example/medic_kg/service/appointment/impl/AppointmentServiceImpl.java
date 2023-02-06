package com.example.medic_kg.service.appointment.impl;

import com.example.medic_kg.dto.AppointmentRequest;
import com.example.medic_kg.dto.AppointmentResponse;
import com.example.medic_kg.entity.doctor.Appointment;
import com.example.medic_kg.repository.doctor.AppointmentRepository;
import com.example.medic_kg.repository.doctor.DoctorRepository;
import com.example.medic_kg.repository.patient.PatientRepository;
import com.example.medic_kg.service.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository userRepository;

    private Appointment appointment;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> findById(int id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public ResponseEntity<AppointmentResponse> add(AppointmentRequest appointmentRequest) {
        var appointment = Appointment.builder()
                .date(appointmentRequest.getDate())
                .approved(Boolean.TRUE)
                .patient(appointmentRequest.getPUser())
                .doctor(appointmentRequest.getDUser())
                .build();

        System.out.println(appointmentRequest);
        appointmentRepository.save(appointment);

        return ResponseEntity.ok(AppointmentResponse
                .builder()
                .msg("Appointment created!!!")
                .build());
    }

    @Override
    public void update(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void delete(int id) {
        appointmentRepository.deleteById(id);
    }
}
