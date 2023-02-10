package com.example.medic_kg.service.doctor.impl;

import com.example.medic_kg.dto.requests.DoctorRequest;
import com.example.medic_kg.entity.doctor.Doctor;
import com.example.medic_kg.entity.doctor.DoctorEntityToDto;
import com.example.medic_kg.entity.user.User;
import com.example.medic_kg.repository.doctor.DoctorRepository;
import com.example.medic_kg.service.doctor.DoctorService;
import com.example.medic_kg.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorEntityToDto entityToDto;

    private final UserService userService;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, DoctorEntityToDto entityToDto, UserService userService) {
        this.doctorRepository = doctorRepository;
        this.entityToDto = entityToDto;
        this.userService = userService;
    }

    @Override
    public ResponseEntity<String> getALl() {
        List<Doctor> doctor = doctorRepository.findAll();
        entityToDto.entityToDto(doctor);

        return ResponseEntity.status(200).body("All doctors");
    }

    @Override
    public Doctor getById(int id) {
        Doctor doctor = doctorRepository.getById(id);

        return doctor;
    }

    @Override
    public ResponseEntity<String> add(DoctorRequest doctorRequest) {
        Doctor doctor = new Doctor();
        User user = userService.getById(doctorRequest.getUser().getId());
        doctor.setInn(doctorRequest.getInn());
        doctor.setExperience(doctorRequest.getExperience());
        doctor.setFullInfo(doctorRequest.getFullInfo());
        doctor.setShortInfo(doctorRequest.getShortInfo());
        doctor.setCity(doctorRequest.getCity());
        doctor.setCountry(doctorRequest.getCountry());
        doctor.setVisitPrice(doctorRequest.getVisitPrice());
        doctor.setHomeVisitPrice(doctorRequest.getHomeVisitPrice());
        doctor.setIsPediatrist(doctorRequest.getIsPediatrist());
        doctor.setIsFamilyDoctor(doctorRequest.getIsFamilyDoctor());
        doctor.setIsCertificated(doctorRequest.getIsCertificated());
        doctor.setIsPrivatePractice(doctorRequest.getIsPrivatePractice());
        doctor.setUser(user);

        doctorRepository.save(doctor);

        return ResponseEntity.status(201).body("Created patient");
    }

    @Override
    public ResponseEntity<String> update(DoctorRequest doctorRequest) {
        Doctor doctor = new Doctor();
        User user = userService.getById(doctorRequest.getUser().getId());
        doctor.setInn(doctorRequest.getInn());
        doctor.setExperience(doctorRequest.getExperience());
        doctor.setFullInfo(doctorRequest.getFullInfo());
        doctor.setShortInfo(doctorRequest.getShortInfo());
        doctor.setCity(doctorRequest.getCity());
        doctor.setCountry(doctorRequest.getCountry());
        doctor.setVisitPrice(doctorRequest.getVisitPrice());
        doctor.setHomeVisitPrice(doctorRequest.getHomeVisitPrice());
        doctor.setIsPediatrist(doctorRequest.getIsPediatrist());
        doctor.setIsFamilyDoctor(doctorRequest.getIsFamilyDoctor());
        doctor.setIsCertificated(doctorRequest.getIsCertificated());
        doctor.setIsPrivatePractice(doctorRequest.getIsPrivatePractice());
        doctor.setUser(user);

        doctorRepository.save(doctor);

        return ResponseEntity.status(201).body("Created patient");
    }

    @Override
    public ResponseEntity<String> delete(int id) {
        doctorRepository.deleteById(id);
        return ResponseEntity.status(202).body("Doctor deleted");
    }
}
