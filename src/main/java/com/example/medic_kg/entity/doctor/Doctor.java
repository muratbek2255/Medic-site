package com.example.medic_kg.entity.doctor;

import com.example.medic_kg.dto.ClinicRequest;
import com.example.medic_kg.dto.DoctorRequest;
import com.example.medic_kg.entity.clinic.Clinic;
import com.example.medic_kg.entity.enums.user.Gender;
import com.example.medic_kg.entity.roles.Roles;
import com.example.medic_kg.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;
import java.util.List;


@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "doctors", schema = "medic_kg")
public class Doctor{
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "inn")
    private String inn;

    @Column(name = "experience")
    private String experience;

    @Column(name = "full_info")
    private String fullInfo;

    @Column(name = "short_info")
    private String shortInfo;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "visit_price")
    private Integer visitPrice;

    @Column(name = "home_visit_price")
    private Integer homeVisitPrice;

    @Column(name = "is_pediatrist")
    private Boolean isPediatrist;

    @Column(name = "is_family_doctor")
    private Boolean isFamilyDoctor;

    @Column(name = "is_certificated")
    private Boolean isCertificated;

    @Column(name = "is_private_practice")
    private Boolean isPrivatePractice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private User user;

    public DoctorRequest entityToDto(Doctor doctor) {
        ModelMapper modelMapper = new ModelMapper();
        DoctorRequest doctorRequest = modelMapper.map(doctor, DoctorRequest.class);
        return doctorRequest;
    }
}
