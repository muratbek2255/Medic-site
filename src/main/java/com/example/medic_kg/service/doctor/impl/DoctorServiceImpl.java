package com.example.medic_kg.service.doctor.impl;

import com.example.medic_kg.dto.CreateUpdateDeleteResponse;
import com.example.medic_kg.dto.DoctorRequest;
import com.example.medic_kg.entity.doctor.Doctor;
import com.example.medic_kg.entity.doctor.DoctorEntityToDto;
import com.example.medic_kg.repository.doctor.DoctorRepository;
import com.example.medic_kg.service.doctor.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private final DoctorRepository doctorRepository;
    private final DoctorEntityToDto entityToDto;

    @Override
    public List<DoctorRequest> getALl() {
        List<Doctor> doctor = doctorRepository.findAll();
        return entityToDto.entityToDto(doctor);
    }

    @Override
    public DoctorRequest findById(int id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        return entityToDto.entityToDto(doctor);
    }

    @Override
    public CreateUpdateDeleteResponse add(DoctorRequest doctorRequest) {
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

        return CreateUpdateDeleteResponse.builder()
                .msg("doctor created!!!")
                .build();
    }

    @Override
    public CreateUpdateDeleteResponse update(DoctorRequest doctorRequest) {
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

        return CreateUpdateDeleteResponse.builder()
                .msg("doctor updated!!!")
                .build();
    }

    @Override
    public CreateUpdateDeleteResponse delete(int id) {
        doctorRepository.deleteById(id);
        return CreateUpdateDeleteResponse.builder().msg("Clinic deleted!!!").build();
    }
}
