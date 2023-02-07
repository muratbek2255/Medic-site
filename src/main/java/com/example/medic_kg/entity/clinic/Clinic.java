package com.example.medic_kg.entity.clinic;


import com.example.medic_kg.dto.ClinicRequest;
import com.example.medic_kg.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.List;


@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "clinics", schema = "medic_kg")
public class Clinic {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fullname")
    private String fullName;

    @Column(name="shortname")
    private String shortName;

    @Column(name = "full_description")
    private String fullDescription;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name="url_site")
    private String urlSite;

    @Column(name = "ownership")
    private String ownerShip;

    @Column(name = "is_draft")
    private Boolean isDraft;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinic", fetch = FetchType.LAZY)
    List<ClinicBranch> clinicBranches;
}
