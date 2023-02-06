package com.example.medic_kg.entity.doctor;

import com.example.medic_kg.entity.enums.doctor.AppointmentEnum;
import com.example.medic_kg.entity.patient.Patient;
import jakarta.persistence.*;
import lombok.*;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "appointments_doctor", schema = "medic_kg")
public class Appointment {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private String date;

    @Column(name = "approved")
    private Boolean approved;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}

