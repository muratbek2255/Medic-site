package com.example.medic_kg.dto.requests;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDetailRequest {
    private Long id;
    private String reason;
    private String treatment;
    private String prescription;
    private String note;
}
