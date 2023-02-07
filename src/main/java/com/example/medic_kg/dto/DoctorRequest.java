package com.example.medic_kg.dto;


import com.example.medic_kg.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DoctorRequest {
    private String inn;
    private String experience;
    private String fullInfo;
    private String shortInfo;
    private String city;
    private String country;
    private Integer visitPrice;
    private Integer homeVisitPrice;
    private Boolean isPediatrist;
    private Boolean isFamilyDoctor;
    private Boolean isCertificated;
    private Boolean isPrivatePractice;
    private User user;
}
