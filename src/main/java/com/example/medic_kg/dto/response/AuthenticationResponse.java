package com.example.medic_kg.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AuthenticationResponse {

    private String token;

    private String email_token;
}