package com.example.medic_kg.service.appointment.impl;

import com.example.medic_kg.dto.AppointmentRequest;
import com.example.medic_kg.entity.doctor.Appointment;
import com.example.medic_kg.entity.doctor.AppointmentEntityToDto;
import com.example.medic_kg.entity.doctor.Doctor;
import com.example.medic_kg.entity.patient.Patient;
import com.example.medic_kg.repository.doctor.AppointmentRepository;
import com.example.medic_kg.service.appointment.AppointmentService;
import com.example.medic_kg.service.doctor.impl.DoctorServiceImpl;
import com.example.medic_kg.service.patient.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;;
    private final AppointmentEntityToDto appointmentEntityToDto;
    private final Appointment appointment;
    private final PatientServiceImpl patientService;
    private final DoctorServiceImpl doctorService;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AppointmentEntityToDto appointmentEntityToDto, Appointment appointment, PatientServiceImpl patientService, DoctorServiceImpl doctorService) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentEntityToDto = appointmentEntityToDto;
        this.appointment = appointment;
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @Override
    public ResponseEntity<String> getAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        appointmentEntityToDto.entityToDto(appointments);

        return ResponseEntity.status(200).body("All appointments");
    }

    @Override
    public ResponseEntity<String> findById(int id) {
        Appointment appointment1 = appointmentRepository.findById(id).orElse(null);
        appointmentEntityToDto.entityToDto(appointment1);

        return ResponseEntity.status(200).body("Get by id");
    }

    @Override
    public ResponseEntity<String> add(AppointmentRequest appointmentRequest) {
            Patient patient = patientService.getById(appointmentRequest.getPUser().getId());
            Doctor doctor = doctorService.getById(appointmentRequest.getDUser().getId());
            Appointment appointment1 = new Appointment();
            appointment1.setDate(appointmentRequest.getDate());
            appointment1.setApproved(appointmentRequest.getApproved());
            appointment1.setPatient(patient);
            appointment1.setDoctor(doctor);

            appointmentRepository.save(appointment1);

            return ResponseEntity.status(201).body("Created appointment");
    }

    @Override
    public ResponseEntity<String> update(AppointmentRequest appointmentRequest) {
        Patient patient = patientService.getById(appointmentRequest.getPUser().getId());
        Doctor doctor = doctorService.getById(appointmentRequest.getDUser().getId());
        Appointment appointment1 = new Appointment();
        appointment1.setDate(appointmentRequest.getDate());
        appointment1.setApproved(appointmentRequest.getApproved());
        appointment1.setPatient(patient);
        appointment1.setDoctor(doctor);

        appointmentRepository.save(appointment1);

        return ResponseEntity.status(201).body("Updated appointment");
    }

    @Override
    public ResponseEntity<String> delete(int id) {
        appointmentRepository.deleteById(id);

        return ResponseEntity.status(202).body("Deleted appointment");
    }
}
