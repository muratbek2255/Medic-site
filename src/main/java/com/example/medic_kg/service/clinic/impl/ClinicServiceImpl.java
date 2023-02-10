package com.example.medic_kg.service.clinic.impl;

import com.example.medic_kg.dto.ClinicRequest;
import com.example.medic_kg.entity.clinic.Clinic;
import com.example.medic_kg.entity.clinic.ClinicEntityToDto;
import com.example.medic_kg.entity.patient.Patient;
import com.example.medic_kg.entity.user.User;
import com.example.medic_kg.repository.clinics.ClinicRepository;
import com.example.medic_kg.service.clinic.ClinicService;
import com.example.medic_kg.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private final ClinicRepository clinicRepository;

    private ClinicEntityToDto clinic;

    private final UserService userService;

    public ClinicServiceImpl(ClinicRepository clinicRepository, UserService userService) {
        this.clinicRepository = clinicRepository;
        this.userService = userService;
    }


    @Override
    public ResponseEntity<String> getALl() {
        List<Clinic> findAll = clinicRepository.findAll();
        clinic.entityToDto(findAll);

        return ResponseEntity.status(200).body("All clinics");
    }

    @Override
    public ResponseEntity<String> getById(int id) {
        Optional<Clinic> clinic1 = clinicRepository.findById(id);
        clinic.entityToDto(clinic1);

        return ResponseEntity.status(200).body("Clinic by id");
    }

    @Override
    public ResponseEntity<String> add(ClinicRequest clinicRequest) {
        Clinic clinic1 = new Clinic();
        User user = userService.getById(clinicRequest.getUser().getId());
        clinic1.setFullName(clinicRequest.getFullName());
        clinic1.setShortName(clinicRequest.getShortName());
        clinic1.setFullDescription(clinicRequest.getFullDescription());
        clinic1.setShortDescription(clinicRequest.getShortDescription());
        clinic1.setUrlSite(clinicRequest.getUrlSite());
        clinic1.setOwnerShip(clinicRequest.getOwnerShip());
        clinic1.setIsDraft(clinicRequest.getIs_draft());
        clinic1.setUser(user);

        clinicRepository.save(clinic1);

        return ResponseEntity.status(201).body(String.format("Clinic Created!!!"));
    }

    @Override
    public ResponseEntity<String> update(ClinicRequest clinicRequest) {
        Clinic clinic1 = new Clinic();
        User user = userService.getById(clinicRequest.getUser().getId());
        clinic1.setFullName(clinicRequest.getFullName());
        clinic1.setShortName(clinicRequest.getShortName());
        clinic1.setFullDescription(clinicRequest.getFullDescription());
        clinic1.setShortDescription(clinicRequest.getShortDescription());
        clinic1.setUrlSite(clinicRequest.getUrlSite());
        clinic1.setOwnerShip(clinicRequest.getOwnerShip());
        clinic1.setIsDraft(clinicRequest.getIs_draft());
        clinic1.setUser(user);

        clinicRepository.save(clinic1);

        return ResponseEntity.status(201).body(String.format("Clinic Created!!!"));
    }

    @Override
    public ResponseEntity<String> delete(int id) {
        clinicRepository.deleteById(id);
        return ResponseEntity.status(202).body(String.format("Deleted!!!"));
    }
}
