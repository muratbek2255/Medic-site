package com.example.medic_kg.entity.token;

import com.example.medic_kg.entity.patient.Patient;
import com.example.medic_kg.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_tokens", schema = "medic_kg")
public class ConfirmationToken {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @Column(nullable = false)
    private String token;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "expired_at", nullable = false)
    private LocalDateTime expiredAt;

    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(name = "fk_patient_id", nullable = false)
    private User user;

    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiredAt,
                             User user
    ) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.user = user;
    }
}