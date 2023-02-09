package com.example.medic_kg.service.doctor.impl;

import com.example.medic_kg.dto.DoctorRequest;
import com.example.medic_kg.entity.doctor.Doctor;
import com.example.medic_kg.entity.doctor.DoctorEntityToDto;
import com.example.medic_kg.repository.doctor.DoctorRepository;
import com.example.medic_kg.service.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ResourceBundle;


@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorEntityToDto entityToDto;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, DoctorEntityToDto entityToDto) {
        this.doctorRepository = doctorRepository;
        this.entityToDto = entityToDto;
    }

    @Override
    public ResponseEntity<String> getALl() {
        List<Doctor> doctor = doctorRepository.findAll();
        entityToDto.entityToDto(doctor);

        return ResponseEntity.status(200).body("All doctors");
    }

    @Override
    public ResponseEntity<String> findById(int id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        entityToDto.entityToDto(doctor);

        return ResponseEntity.status(200).body("Get by id doctor");
    }

    @Override
    public ResponseEntity<String> add(DoctorRequest doctorRequest) {
        var doctor = Doctor.builder()
                .inn(doctorRequest.getInn())
                .experience(doctorRequest.getExperience())
                .fullInfo(doctorRequest.getFullInfo())
                .shortInfo(doctorRequest.getShortInfo())
                .city(doctorRequest.getCity())
                .country(doctorRequest.getCountry())
                .visitPrice(doctorRequest.getVisitPrice())
                .homeVisitPrice(doctorRequest.getHomeVisitPrice())
                .isPediatrist(doctorRequest.getIsPediatrist())
                .isFamilyDoctor(doctorRequest.getIsFamilyDoctor())
                .isCertificated(doctorRequest.getIsCertificated())
                .isPrivatePractice(doctorRequest.getIsPrivatePractice())
                .user(doctorRequest.getUser())
                .build();

        doctorRepository.save(doctor);

        return ResponseEntity.status(201).body("Doctor created");
    }

    @Override
    public ResponseEntity<String> update(DoctorRequest doctorRequest) {
        var doctor2 = Doctor.builder()
                .inn(doctorRequest.getInn())
                .experience(doctorRequest.getExperience())
                .fullInfo(doctorRequest.getFullInfo())
                .shortInfo(doctorRequest.getShortInfo())
                .city(doctorRequest.getCity())
                .country(doctorRequest.getCountry())
                .visitPrice(doctorRequest.getVisitPrice())
                .homeVisitPrice(doctorRequest.getHomeVisitPrice())
                .isPediatrist(doctorRequest.getIsPediatrist())
                .isFamilyDoctor(doctorRequest.getIsFamilyDoctor())
                .isCertificated(doctorRequest.getIsCertificated())
                .isPrivatePractice(doctorRequest.getIsPrivatePractice())
                .user(doctorRequest.getUser())
                .build();

        doctorRepository.save(doctor2);

        return ResponseEntity.status(201).body("Doctor created");
    }

    @Override
    public ResponseEntity<String> delete(int id) {
        doctorRepository.deleteById(id);
        return ResponseEntity.status(202).body("Doctor deleted");
    }
}
