package com.example.medic_kg.dto.requests;


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
public class ClinicRequest {
    private String fullName;
    private String shortName;
    private String fullDescription;
    private String shortDescription;
    private String urlSite;
    private String ownerShip;
    private Boolean is_draft;
    private UserRequest user;
}
