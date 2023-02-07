package com.example.medic_kg.service.doctor;

import com.example.medic_kg.dto.CreateUpdateDeleteResponse;
import com.example.medic_kg.dto.DoctorRequest;
import com.example.medic_kg.entity.doctor.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    public List<DoctorRequest> getALl();

    public DoctorRequest findById(int id);

    public CreateUpdateDeleteResponse add(DoctorRequest doctorRequest);

    public CreateUpdateDeleteResponse update(DoctorRequest doctorRequest);

    public CreateUpdateDeleteResponse delete(int id);
}
