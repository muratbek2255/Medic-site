package com.example.medic_kg.entity.patient;

import com.example.medic_kg.dto.DoctorRequest;
import com.example.medic_kg.dto.PatientRequest;
import com.example.medic_kg.entity.doctor.Appointment;
import com.example.medic_kg.entity.doctor.Doctor;
import com.example.medic_kg.entity.enums.user.Gender;
import com.example.medic_kg.entity.roles.Roles;
import com.example.medic_kg.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;


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
    @JoinColumn(name = "fk_user_fk_id")
    private User user;

    public PatientRequest entityToDto(Patient patient) {
        ModelMapper modelMapper = new ModelMapper();
        PatientRequest patientRequest = modelMapper.map(patient, PatientRequest.class);
        return patientRequest;
    }
}
