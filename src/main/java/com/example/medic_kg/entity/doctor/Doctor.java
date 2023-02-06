package com.example.medic_kg.entity.doctor;

import com.example.medic_kg.entity.enums.user.Gender;
import com.example.medic_kg.entity.roles.Roles;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(unique = true, nullable = false, name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(unique = true, nullable = false, name = "avatar")
    private String avatar;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "date_birthday")
    private Timestamp date_birthday;

    @Column(nullable = false, name = "password")
    private String password;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Roles role;

    @Column(name = "inn")
    private String inn;

    @Column(name = "experience")
    private String experience;

    @Column(name = "full_info")
    private String fullInfo;

    @Column(name = "short_info")
    private String short_info;

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
}
