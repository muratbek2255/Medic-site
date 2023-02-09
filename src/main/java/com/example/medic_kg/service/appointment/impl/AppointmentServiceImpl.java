package com.example.medic_kg.service.appointment.impl;

import com.example.medic_kg.dto.AppointmentRequest;
import com.example.medic_kg.entity.doctor.Appointment;
//import com.example.medic_kg.entity.doctor.AppointmentEntityToDto;
//import com.example.medic_kg.repository.doctor.AppointmentRepository;
//import com.example.medic_kg.repository.doctor.DoctorRepository;
//import com.example.medic_kg.repository.patient.PatientRepository;
//import com.example.medic_kg.service.appointment.AppointmentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class AppointmentServiceImpl implements AppointmentService {
//
//    private AppointmentRepository appointmentRepository;
//    private DoctorRepository doctorRepository;
//    private PatientRepository userRepository;
//    private AppointmentEntityToDto appointmentEntityToDto;
//    private Appointment appointment;
//
//    @Autowired
//    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository userRepository, AppointmentEntityToDto appointmentEntityToDto, Appointment appointment) {
//        this.appointmentRepository = appointmentRepository;
//        this.doctorRepository = doctorRepository;
//        this.userRepository = userRepository;
//        this.appointmentEntityToDto = appointmentEntityToDto;
//        this.appointment = appointment;
//    }
//
//    @Override
//    public ResponseEntity<String> getAll() {
//        List<Appointment> appointments = appointmentRepository.findAll();
//        appointmentEntityToDto.entityToDto(appointments);
//
//        return ResponseEntity.status(200).body("All appointments");
//    }
//
//    @Override
//    public ResponseEntity<String> findById(int id) {
//        Appointment appointment1 = appointmentRepository.findById(id).orElse(null);
//        appointmentEntityToDto.entityToDto(appointment1);
//
//        return ResponseEntity.status(200).body("Get by id");
//    }
//
////    @Override
////    public ResponseEntity<String> add(AppointmentRequest appointmentRequest) {
////        var appointment = Appointment.builder()
////                .date(appointmentRequest.getDate())
////                .approved(Boolean.TRUE)
////                .patient(appointmentRequest.getPUser())
////                .doctor(appointmentRequest.getDUser())
////                .build();
////
////        System.out.println(appointmentRequest);
////        appointmentRepository.save(appointment);
////
////        return ResponseEntity.status(201).body("Appointment created");
////    }
////
////    @Override
////    public ResponseEntity<String> update(AppointmentRequest appointmentRequest) {
////        var appointment = Appointment.builder()
////                .date(appointmentRequest.getDate())
////                .approved(appointmentRequest.getApproved())
////                .patient(appointmentRequest.getPUser())
////                .doctor(appointmentRequest.getDUser())
////                .build();
////
////        System.out.println(appointmentRequest);
////        appointmentRepository.save(appointment);
////
////        return ResponseEntity.status(201).body("Updated appointment");
////    }
//
//    @Override
//    public ResponseEntity<String> delete(int id) {
//        appointmentRepository.deleteById(id);
//
//        return ResponseEntity.status(202).body("Deleted appointment");
//    }
//}
