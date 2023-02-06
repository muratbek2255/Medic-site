package com.example.medic_kg.service.doctor;

import com.example.medic_kg.entity.doctor.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    public List<Doctor> getALl();

    public Optional<Doctor> findById(int id);

    public void add(Doctor doctor);

    public void update(Doctor doctor);

    public void delete(int id);
}
