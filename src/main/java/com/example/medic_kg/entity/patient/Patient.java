package com.example.medic_kg.entity.patient;

import com.example.medic_kg.entity.user.User;
import jakarta.persistence.*;
import lombok.*;


@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "patients", schema = "medic_kg")
public class Patient{

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "blood_type")
    private Integer bloodType;

    @Column(name = "info")
    private String info;

    @Column(name = "address")
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_fk_id", referencedColumnName = "id")
    private User user;
}
