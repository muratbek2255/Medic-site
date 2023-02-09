package com.example.medic_kg.service.clinic.impl;

import com.example.medic_kg.dto.ClinicRequest;
import com.example.medic_kg.dto.UserRequest;
import com.example.medic_kg.entity.clinic.Clinic;
import com.example.medic_kg.entity.clinic.ClinicEntityToDto;
import com.example.medic_kg.entity.user.User;
import com.example.medic_kg.repository.clinics.ClinicRepository;
import com.example.medic_kg.service.clinic.ClinicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private final ClinicRepository clinicRepository;

    private ClinicEntityToDto clinic;

    private User user;

    public ClinicServiceImpl(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }


    @Override
    public ResponseEntity<String> getALl() {
        List<Clinic> findAll = clinicRepository.findAll();
        clinic.entityToDto(findAll);

        return ResponseEntity.status(200).body("All clinics");
    }

    @Override
    public ResponseEntity<String> findById(int id) {
        Clinic clinic1 = clinicRepository.findById(id).orElse(null);
        clinic.entityToDto(clinic1);

        return ResponseEntity.status(200).body("Clinic by id");
    }

    @Override
    public ResponseEntity<String> add(ClinicRequest clinicRequest) {
        var clinic = Clinic.builder()
                .fullName(clinicRequest.getFullName())
                .shortName(clinicRequest.getShortName())
                .fullDescription(clinicRequest.getFullDescription())
                .shortDescription(clinicRequest.getShortDescription())
                .urlSite(clinicRequest.getUrlSite())
                .ownerShip(clinicRequest.getOwnerShip())
                .isDraft(clinicRequest.getIs_draft())
                .user(user)
                .build();

        clinicRepository.save(clinic);

        return ResponseEntity.status(201).body(String.format("Created!!!"));
    }

    @Override
    public ResponseEntity<String> update(ClinicRequest clinicRequest) {
        var clinic1 = Clinic.builder()
                .fullName(clinicRequest.getFullName())
                .shortName(clinicRequest.getShortName())
                .fullDescription(clinicRequest.getFullDescription())
                .shortDescription(clinicRequest.getShortDescription())
                .urlSite(clinicRequest.getUrlSite())
                .ownerShip(clinicRequest.getOwnerShip())
                .isDraft(clinicRequest.getIs_draft())
                .user(clinicRequest.getUser())
                .build();

        clinicRepository.save(clinic1);

        return ResponseEntity.status(201).body(String.format("Updated!!!"));
    }

    @Override
    public ResponseEntity<String> delete(int id) {
        clinicRepository.deleteById(id);
        return ResponseEntity.status(202).body(String.format("Deleted!!!"));
    }
}
