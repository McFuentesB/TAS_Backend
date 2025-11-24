package com.tuhoraya.profesion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests(auth -> auth
                // Permitir consultas GET sin autenticación (acceso público)
                .requestMatchers(org.springframework.http.HttpMethod.GET, "/profesion/**").permitAll()
                .requestMatchers(org.springframework.http.HttpMethod.GET, "/rubro/**").permitAll()
                .requestMatchers(org.springframework.http.HttpMethod.GET, "/servicioprofesional/**").permitAll()
                // Todos los demás endpoints requieren autenticación
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth2 -> oauth2
                .jwt(Customizer.withDefaults())
            );

        return http.build();
    }
}
