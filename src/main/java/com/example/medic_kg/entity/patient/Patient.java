package com.example.medic_kg.entity.patient;

import com.example.medic_kg.entity.doctor.Appointment;
import com.example.medic_kg.entity.enums.user.Gender;
import com.example.medic_kg.entity.roles.Roles;
import jakarta.persistence.*;
import lombok.*;
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

public class Patient implements UserDetails {

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

    @Column(name = "blood_type")
    private Integer bloodType;

    @Column(name = "info")
    private String info;

    @Column(name = "address")
    private String address;
    private Boolean locked = false;
    private Boolean enabled = false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.getName()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
