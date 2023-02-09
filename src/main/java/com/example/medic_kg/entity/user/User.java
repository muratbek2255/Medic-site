package com.example.medic_kg.entity.user;

import com.example.medic_kg.entity.enums.user.Gender;
import com.example.medic_kg.entity.patient.Patient;
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
@Table(name = "users",schema = "medic_kg")
public class User implements UserDetails {

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

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "user")
//    private List<Patient> patients;

    private Boolean locked = false;
    private Boolean enabled = false;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    private Patient patient;

    public User(int id, String username, String email, String avatar, String male, String s, String password, String rolePatient, boolean locked, boolean enabled) {
    }

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
