package com.example.medic_kg.dto;


import com.example.medic_kg.entity.patient.Patient;
import com.example.medic_kg.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@Component
@ToString
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PatientRequest{
    private Integer bloodType;
    private String info;
    private String address;
    private UserRequest user;
}
