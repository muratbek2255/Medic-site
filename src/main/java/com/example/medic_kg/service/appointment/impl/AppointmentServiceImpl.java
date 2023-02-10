package com.example.medic_kg.service.appointment.impl;

import com.example.medic_kg.dto.requests.AppointmentRequest;
import com.example.medic_kg.entity.doctor.Appointment;
import com.example.medic_kg.entity.doctor.AppointmentDetail;
import com.example.medic_kg.entity.doctor.AppointmentEntityToDto;
import com.example.medic_kg.entity.doctor.Doctor;
import com.example.medic_kg.entity.enums.doctor.AppointmentEnum;
import com.example.medic_kg.entity.patient.Patient;
import com.example.medic_kg.exception_handling.NoSuchUnknownException;
import com.example.medic_kg.repository.doctor.AppointmentRepository;
import com.example.medic_kg.service.appointment.AppointmentDetailService;
import com.example.medic_kg.service.appointment.AppointmentService;
import com.example.medic_kg.service.doctor.impl.DoctorServiceImpl;
import com.example.medic_kg.service.patient.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;;
    private final AppointmentEntityToDto appointmentEntityToDto;
    private final Appointment appointment;
    private final PatientServiceImpl patientService;
    private final DoctorServiceImpl doctorService;
    private final AppointmentDetailService appointmentDetailService;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AppointmentEntityToDto appointmentEntityToDto, Appointment appointment, PatientServiceImpl patientService, DoctorServiceImpl doctorService, AppointmentDetailService appointmentDetailService) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentEntityToDto = appointmentEntityToDto;
        this.appointment = appointment;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.appointmentDetailService = appointmentDetailService;
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
            AppointmentDetail appointmentDetail = appointmentDetailService.getById(appointmentRequest.getAppointmentDetailRequest().getId());
            Appointment appointment1 = new Appointment();
            appointment1.setStarttime((Date) appointmentRequest.getStarttime());
            appointment1.setEndtime((Date) appointmentRequest.getEndtime());
            appointment1.setStatus(AppointmentEnum.BOOKED);
            appointment1.setPatient(patient);
            appointment1.setDoctor(doctor);
            appointment1.setAppointmentdetail(appointmentDetail);
            appointmentRepository.save(appointment1);

            return ResponseEntity.status(201).body("Created appointment");
    }

    @Override
    public ResponseEntity<String> update(AppointmentRequest appointmentRequest) {
        Patient patient = patientService.getById(appointmentRequest.getPUser().getId());
        Doctor doctor = doctorService.getById(appointmentRequest.getDUser().getId());
        AppointmentDetail appointmentDetail = appointmentDetailService.getById(appointmentRequest.getAppointmentDetailRequest().getId());
        Appointment appointment1 = new Appointment();
        appointment1.setStarttime((Date) appointmentRequest.getStarttime());
        appointment1.setEndtime((Date) appointmentRequest.getEndtime());
        appointment1.setStatus(AppointmentEnum.BOOKED);
        appointment1.setPatient(patient);
        appointment1.setDoctor(doctor);
        appointment1.setAppointmentdetail(appointmentDetail);

        appointmentRepository.save(appointment1);

        return ResponseEntity.status(201).body("Updated appointment");
    }

    @Override
    public ResponseEntity<String> delete(int id) {
        appointmentRepository.deleteById(id);

        return ResponseEntity.status(202).body("Deleted appointment");
    }

    public List<Appointment> getAppointmentAfterThisDate(Date date) {
        return appointmentRepository.getAppointmentsAfterThisDate(date);
    }

    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        return appointmentRepository.getAppointmentsByPatientId(patientId);
    }

    public List<Appointment> getAppointmentByPatientAndStatus(int patientId, int status) {
        return appointmentRepository.getAppointmentsByPatientIdAndStatus(patientId, status);
    }
}
