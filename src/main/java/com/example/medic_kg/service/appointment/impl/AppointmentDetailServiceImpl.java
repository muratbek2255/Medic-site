package com.example.medic_kg.service.appointment.impl;

import com.example.medic_kg.dto.requests.AppointmentDetailRequest;
import com.example.medic_kg.entity.doctor.AppointmentDetail;
import com.example.medic_kg.repository.doctor.AppointmentDetailRepository;
import com.example.medic_kg.service.appointment.AppointmentDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppointmentDetailServiceImpl implements AppointmentDetailService {

    private final AppointmentDetailRepository appointmentDetailRepository;

    public AppointmentDetailServiceImpl(AppointmentDetailRepository appointmentDetailRepository) {
        this.appointmentDetailRepository = appointmentDetailRepository;
    }

    @Override
    public List<AppointmentDetail> getAll() {
        return appointmentDetailRepository.findAll();
    }

    @Override
    public AppointmentDetail getById(long id) {
        AppointmentDetail appointmentDetail = appointmentDetailRepository.getById(id);
        return appointmentDetail;
    }

    @Override
    public ResponseEntity<String> add(AppointmentDetailRequest appointmentRequest) {
        AppointmentDetail appointmentDetail = new AppointmentDetail();
        appointmentDetail.setId(appointmentRequest.getId());
        appointmentDetail.setReason(appointmentRequest.getReason());
        appointmentDetail.setTreatment(appointmentRequest.getTreatment());
        appointmentDetail.setPrescription(appointmentRequest.getPrescription());
        appointmentDetail.setNote(appointmentRequest.getNote());

        appointmentDetailRepository.save(appointmentDetail);
        return ResponseEntity.status(201).body("Created appointmentsDetail");
    }

    @Override
    public ResponseEntity<String> update(AppointmentDetailRequest appointmentRequest) {
        AppointmentDetail appointmentDetail = new AppointmentDetail();
        appointmentDetail.setId(appointmentRequest.getId());
        appointmentDetail.setReason(appointmentRequest.getReason());
        appointmentDetail.setTreatment(appointmentRequest.getTreatment());
        appointmentDetail.setPrescription(appointmentRequest.getPrescription());
        appointmentDetail.setNote(appointmentRequest.getNote());

        appointmentDetailRepository.save(appointmentDetail);
        return ResponseEntity.status(201).body("Created appointmentsDetail");
    }

    @Override
    public ResponseEntity<String> delete(long id) {
        appointmentDetailRepository.deleteById(id);
        return ResponseEntity.status(202).body("Deleted appointmentDetail");
    }
}
