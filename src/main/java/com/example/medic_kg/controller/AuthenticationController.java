package com.example.medic_kg.controller;


import com.example.medic_kg.dto.AuthenticationRequest;
import com.example.medic_kg.dto.AuthenticationResponse;
import com.example.medic_kg.dto.RegisterRequest;
import com.example.medic_kg.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest
                                                                       registerRequest){
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest
                                                                   authenticationRequest){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

    @GetMapping(path = "/register/confirm")
    public String confirm(@RequestParam("token") String token) {
        return authenticationService.confirmToken(token);
    }
}
