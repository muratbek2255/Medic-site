package com.example.medic_kg.config;

import com.example.medic_kg.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;

    private static final String[] PERMIT_ALL_WHITELIST = {
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**",
            "/auth/register",
            "/auth/authenticate",
            "/appointment/add",
            "/auth/register/confirm**",
    };

    private static final String[] AUTHENTICATED_WHITELIST = {
            "/appointment/add",
            "/all/clinics",
            "/clinic/{id}",
            "/all/doctors",
            "/doctor/{id}",
    };
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .httpBasic().disable()
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll()
//                .authorizeHttpRequests()
//                .requestMatchers(PERMIT_ALL_WHITELIST)
//                .permitAll()
//                .requestMatchers(AUTHENTICATED_WHITELIST)
//                .authenticated()
//                .anyRequest()
//                .hasRole("ROLE_ADMIN")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
