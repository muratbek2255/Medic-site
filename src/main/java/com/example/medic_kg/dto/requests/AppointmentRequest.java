package com.example.medic_kg.dto.requests;

import com.example.medic_kg.entity.enums.doctor.AppointmentEnum;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AppointmentRequest {
    private Date starttime;

    private Date endtime;
    private AppointmentEnum approved;
    private PatientRequest pUser;
    private DoctorRequest dUser;
    private AppointmentDetailRequest appointmentDetailRequest;
}
