package com.example.medic_kg.service.patient;


import com.example.medic_kg.dto.CreateUpdateDeleteResponse;
import com.example.medic_kg.dto.DoctorRequest;
import com.example.medic_kg.dto.PatientRequest;
import com.example.medic_kg.entity.patient.Patient;

import java.util.List;


public interface PatientService {

    public List<PatientRequest> getALl();
    public PatientRequest findById(int id);
    public CreateUpdateDeleteResponse add(PatientRequest patientRequest);

    public CreateUpdateDeleteResponse update(PatientRequest patientRequest);

    public CreateUpdateDeleteResponse delete(int id);
}
