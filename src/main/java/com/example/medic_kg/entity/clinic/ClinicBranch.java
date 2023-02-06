package com.example.medic_kg.entity.clinic;


import com.example.medic_kg.entity.clinic.Clinic;
import jakarta.persistence.*;
import lombok.*;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "clinic_branches", schema = "medic_kg")
public class ClinicBranch {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "is_house_call")
    private Boolean isHouseCall;

    @Column(name = "is_main_clinic")
    private Boolean isMainClinic;

    @Column(name = "is_draft")
    private Boolean isDraft;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_clinic_id")
    private Clinic clinic;
}
