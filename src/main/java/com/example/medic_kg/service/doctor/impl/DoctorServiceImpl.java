package com.example.medic_kg.service.doctor.impl;

import com.example.medic_kg.entity.doctor.Doctor;
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

    @Override
    public List<Doctor> getALl() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findById(int id) {
        return doctorRepository.findById(id);
    }

    @Override
    public void add(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void update(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void delete(int id) {
        doctorRepository.deleteById(id);
    }
}
