package com.tuhoraya.bff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        // RestTemplate simple, suficiente para nuestro caso
        return new RestTemplate();
    }
}
