package com.example.medic_kg.dto;

import com.example.medic_kg.entity.doctor.Doctor;
import com.example.medic_kg.entity.enums.doctor.AppointmentEnum;
import com.example.medic_kg.entity.patient.Patient;
import lombok.*;

import javax.print.Doc;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AppointmentRequest {
    private String date;

    private Boolean approved;
    private Patient pUser;
    private Doctor dUser;
}
