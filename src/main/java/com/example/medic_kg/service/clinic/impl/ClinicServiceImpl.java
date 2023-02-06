package com.example.medic_kg.service.clinic.impl;

import com.example.medic_kg.entity.clinic.Clinic;
import com.example.medic_kg.repository.clinics.ClinicRepository;
import com.example.medic_kg.service.clinic.ClinicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private final ClinicRepository clinicRepository;

    @Override
    public List<Clinic> getALl() {
        return clinicRepository.findAll();
    }

    @Override
    public Optional<Clinic> findById(int id) {
        return clinicRepository.findById(id);
    }

    @Override
    public void add(Clinic clinic) {
        clinicRepository.save(clinic);
    }

    @Override
    public void update(Clinic clinic) {
        clinicRepository.save(clinic);
    }

    @Override
    public void delete(int id) {
        clinicRepository.deleteById(id);
    }
}
