package com.example.medic_kg.service;


import com.example.medic_kg.entity.token.ConfirmationToken;
import com.example.medic_kg.repository.ConformationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConformationTokenService {
    private final ConformationTokenRepository conformationTokenRepository;

    public void saveTokenConformation(ConfirmationToken token) {
        conformationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return conformationTokenRepository.findByToken(token);
    }

    @Autowired
    public ConformationTokenService(ConformationTokenRepository conformationTokenRepository) {
        this.conformationTokenRepository = conformationTokenRepository;
    }

    public int setConfirmedAt(String token) {
        return conformationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
