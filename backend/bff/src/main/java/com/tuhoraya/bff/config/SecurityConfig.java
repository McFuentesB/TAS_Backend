package com.tuhoraya.bff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /**
     * Cadena 1: SOLO para /bff/usuario/login y /bff/usuario/azure-sync
     * - No usa oauth2ResourceServer
     * - Permite cualquier petición (con o sin Authorization)
     */
    @Bean
    @Order(1)
    public SecurityFilterChain authEntryPoints(HttpSecurity http) throws Exception {
        http
            // Aplica sólo a estos paths
            .securityMatcher("/bff/usuario/login", "/bff/usuario/azure-sync")
            .cors(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            )
            // ⚠️ Desactivar completamente el resource server en esta cadena
            .oauth2ResourceServer(oauth2 -> oauth2.disable())
            .httpBasic(b -> b.disable())
            .formLogin(f -> f.disable());

        return http.build();
    }

    /**
     * Cadena 2: resto del BFF
     * - Aquí sí se valida el JWT
     */
    @Bean
    @Order(2)
    public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {
        http
            .cors(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth2 -> oauth2
                .jwt(Customizer.withDefaults())
            )
            .httpBasic(b -> b.disable())
            .formLogin(f -> f.disable());

        return http.build();
    }
}
