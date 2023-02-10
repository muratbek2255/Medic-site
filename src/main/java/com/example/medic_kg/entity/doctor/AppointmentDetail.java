package com.example.medic_kg.entity.doctor;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@Component
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "appointments_details", schema = "medic_kg")
public class AppointmentDetail {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="reason")
    private String reason;

    @Column(name="treatment")
    private String treatment;

    @Column(name="prescription")
    private String prescription;

    @Column(name="note")
    private String note;

    @OneToOne(mappedBy="appointmentdetail")
    private Appointment appointment;
}
