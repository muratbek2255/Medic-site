package com.example.medic_kg.service.clinic;

import com.example.medic_kg.dto.ClinicRequest;
import com.example.medic_kg.dto.CreateUpdateDeleteResponse;
import com.example.medic_kg.entity.clinic.Clinic;

import java.util.List;
import java.util.Optional;

public interface ClinicService {

    public List<ClinicRequest> getALl();

    public ClinicRequest findById(int id);

    public CreateUpdateDeleteResponse add(ClinicRequest clinicRequest);

    public CreateUpdateDeleteResponse update(ClinicRequest clinic);

    public CreateUpdateDeleteResponse delete(int id);
}
