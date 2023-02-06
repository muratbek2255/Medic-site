package com.example.medic_kg.entity.clinic;


import com.example.medic_kg.entity.clinic.ClinicBranch;
import jakarta.persistence.*;
import lombok.*;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "clinic_schedules", schema = "medic_kg")
public class ClinicSchedule {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "day")
    private String day;

    @Column(name = "hour_start")
    private String hourStart;

    @Column(name = "hour_end")
    private String hourEnd;

    @Column(name = "work_24h")
    private Boolean work24F;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_clinic_branch_id")
    private ClinicBranch clinicBranch;
}
