package com.example.medic_kg.service.clinic.impl;

import com.example.medic_kg.dto.ClinicRequest;
import com.example.medic_kg.dto.CreateUpdateDeleteResponse;
import com.example.medic_kg.entity.clinic.Clinic;
import com.example.medic_kg.entity.clinic.ClinicEntityToDto;
import com.example.medic_kg.repository.clinics.ClinicRepository;
import com.example.medic_kg.service.clinic.ClinicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClinicServiceImpl implements ClinicService {

    private final ClinicRepository clinicRepository;
    private final ClinicEntityToDto clinic;


    @Autowired
    public ClinicServiceImpl(ClinicRepository clinicRepository, ClinicEntityToDto clinic) {
        this.clinicRepository = clinicRepository;
        this.clinic = clinic;
    }

    @Override
    public List<ClinicRequest> getALl() {
        List<Clinic> findAll = clinicRepository.findAll();
        return clinic.entityToDto(findAll);
    }

    @Override
    public ClinicRequest findById(int id) {
        Clinic clinic1 = clinicRepository.findById(id).orElse(null);
        return clinic.entityToDto(clinic1);
    }

    @Override
    public CreateUpdateDeleteResponse add(ClinicRequest clinicRequest) {
        var clinic = Clinic.builder()
                .fullName(clinicRequest.getFullName())
                .shortName(clinicRequest.getShortName())
                .fullDescription(clinicRequest.getFullDescription())
                .shortDescription(clinicRequest.getShortDescription())
                .urlSite(clinicRequest.getUrlSite())
                .ownerShip(clinicRequest.getOwnerShip())
                .isDraft(clinicRequest.getIs_draft())
                .user(clinicRequest.getUser())
                .build();

        clinicRepository.save(clinic);

        return CreateUpdateDeleteResponse.builder()
                .msg("Clinic created!!!")
                .build();
    }

    @Override
    public CreateUpdateDeleteResponse update(ClinicRequest clinicRequest) {
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

        return CreateUpdateDeleteResponse.builder()
                .msg("Clinic updated!!!")
                .build();
    }

    @Override
    public CreateUpdateDeleteResponse delete(int id) {
        clinicRepository.deleteById(id);
        return CreateUpdateDeleteResponse.builder().msg("Clinic deleted!!!").build();
    }
}
