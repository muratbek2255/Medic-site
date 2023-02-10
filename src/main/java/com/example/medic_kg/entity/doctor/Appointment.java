package com.example.medic_kg.entity.doctor;

import com.example.medic_kg.entity.enums.doctor.AppointmentEnum;
import com.example.medic_kg.entity.patient.Patient;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Entity
@Component
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

    @Column(name="starttime")
    private Date starttime;

    @Column(name="endtime")
    private Date endtime;

    @Column(name="status")
    private AppointmentEnum status;

    @OneToOne
    @JoinColumn(name="appointmentdetail_id")
    private AppointmentDetail appointmentdetail;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}

