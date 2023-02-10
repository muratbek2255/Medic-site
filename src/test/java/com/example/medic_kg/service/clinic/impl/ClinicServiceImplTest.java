package com.example.medic_kg.service.clinic.impl;

import com.example.medic_kg.repository.clinics.ClinicRepository;
import com.example.medic_kg.repository.user.UserRepository;
import com.example.medic_kg.service.user.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;


@SpringBootTest
class ClinicServiceImplTest {

    @Mock private ClinicRepository clinicRepository;
    @Mock private UserRepository userRepository;
    private AutoCloseable autoCloseable;
    private ClinicServiceImpl underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ClinicServiceImpl(clinicRepository, (UserService) userRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void getALl() {
        underTest.getALl();
        verify(clinicRepository).findAll();
    }

    @Test
    void findById() {
    }

    @Test
    @Disabled
    void add() {
    }

    @Test
    @Disabled
    void update() {
    }

    @Test
    @Disabled
    void delete() {
    }
}