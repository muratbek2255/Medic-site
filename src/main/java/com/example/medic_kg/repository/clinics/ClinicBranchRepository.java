package com.example.medic_kg.repository.clinics;

import com.example.medic_kg.entity.clinic.ClinicBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicBranchRepository extends JpaRepository<ClinicBranch, Integer> {

    ClinicBranch findByAddress(String address);
    ClinicBranch findByCity(String city);
}
