package com.example.medic_kg.service.appointment.impl;

import com.example.medic_kg.dto.AppointmentRequest;
import com.example.medic_kg.dto.CreateUpdateDeleteResponse;
import com.example.medic_kg.entity.doctor.Appointment;
import com.example.medic_kg.entity.doctor.AppointmentEntityToDto;
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
    private AppointmentEntityToDto appointmentEntityToDto;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository userRepository, AppointmentEntityToDto appointmentEntityToDto, Appointment appointment) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
        this.appointmentEntityToDto = appointmentEntityToDto;
    }

    @Override
    public List<AppointmentRequest> getAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointmentEntityToDto.entityToDto(appointments);
    }

    @Override
    public AppointmentRequest findById(int id) {
        Appointment appointment1 = appointmentRepository.findById(id).orElse(null);
        return appointmentEntityToDto.entityToDto(appointment1);
    }

    @Override
    public CreateUpdateDeleteResponse add(AppointmentRequest appointmentRequest) {
        var appointment = Appointment.builder()
                .date(appointmentRequest.getDate())
                .approved(Boolean.TRUE)
                .patient(appointmentRequest.getPUser())
                .doctor(appointmentRequest.getDUser())
                .build();

        System.out.println(appointmentRequest);
        appointmentRepository.save(appointment);

        return CreateUpdateDeleteResponse
                .builder()
                .msg("Appointment created!!!")
                .build();
    }

    @Override
    public CreateUpdateDeleteResponse update(AppointmentRequest appointmentRequest) {
        var appointment = Appointment.builder()
                .date(appointmentRequest.getDate())
                .approved(appointmentRequest.getApproved())
                .patient(appointmentRequest.getPUser())
                .doctor(appointmentRequest.getDUser())
                .build();

        System.out.println(appointmentRequest);
        appointmentRepository.save(appointment);

        return CreateUpdateDeleteResponse
                .builder()
                .msg("Appointment updated!!!")
                .build();
    }

    @Override
    public CreateUpdateDeleteResponse delete(int id) {
        appointmentRepository.deleteById(id);

        return CreateUpdateDeleteResponse
                .builder()
                .msg("Appointment deleted!!!")
                .build();
    }
}
