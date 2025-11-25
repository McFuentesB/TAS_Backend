package com.tuhoraya.usuario.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // Permitir consultas GET de profesionales sin autenticación (acceso público)
                .requestMatchers(HttpMethod.GET, "/usuarioprofesional/**").permitAll()
                // Permitir endpoint de login sin autenticación
                .requestMatchers(HttpMethod.POST, "/usuario/login").permitAll()
                // Permitir endpoint de Azure AD sync sin autenticación
                .requestMatchers(HttpMethod.POST, "/usuario/azure-sync").permitAll()
                // Permitir endpoint de completar onboarding sin autenticación (acepta cualquier ID)
                .requestMatchers(new RegexRequestMatcher("/usuario/[^/]+/complete-onboarding", HttpMethod.PUT.name())).permitAll()
                // Todos los demás endpoints requieren autenticación
                .anyRequest().authenticated()
            )
            // TEMPORARILY DISABLED: JWT validation to allow public endpoints without token
            // TODO: Re-enable once we configure proper JWT validation only for protected endpoints
            // .oauth2ResourceServer(oauth2 -> oauth2
            //     .jwt(Customizer.withDefaults())
            // )
            ;

        return http.build();
    }
}
