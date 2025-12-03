package com.tuhoraya.usuario.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // Público
                .requestMatchers(HttpMethod.GET, "/usuarioprofesional/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/usuario/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/usuario/azure-sync").permitAll()
                .requestMatchers(
                    new RegexRequestMatcher("/usuario/[^/]+/complete-onboarding",
                                            HttpMethod.PUT.name())
                ).permitAll()

                // TODO: si quieres, durante pruebas puedes abrir /usuario:
                // .requestMatchers(HttpMethod.GET, "/usuario/**").permitAll()

                // Todo lo demás requiere token válido
                .anyRequest().authenticated()
            )
            // 🔥 IMPORTANTE: volver a activar el resource server JWT
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

        return http.build();
    }
}
