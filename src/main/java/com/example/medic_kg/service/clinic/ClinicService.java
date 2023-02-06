package com.example.medic_kg.service.clinic;

import com.example.medic_kg.entity.clinic.Clinic;

import java.util.List;
import java.util.Optional;

public interface ClinicService {

    public List<Clinic> getALl();

    public Optional<Clinic> findById(int id);

    public void add(Clinic clinic);

    public void update(Clinic clinic);

    public void delete(int id);
}
