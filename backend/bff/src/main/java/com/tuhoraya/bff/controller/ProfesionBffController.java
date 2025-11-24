package com.tuhoraya.bff.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bff")
public class ProfesionBffController {

    private final RestTemplate restTemplate;

    @Value("${microservices.profesion-url}")
    private String profesionServiceUrl;

    public ProfesionBffController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // ───────────────────────────── helpers ─────────────────────────────

    private ResponseEntity<String> forwardGet(String path, String authorization) {
        String url = profesionServiceUrl + path;
        try {
            HttpHeaders headers = new HttpHeaders();
            if (authorization != null && !authorization.isBlank()) {
                headers.set("Authorization", authorization);
            }
            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<String> response =
                    restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            return ResponseEntity
                    .status(response.getStatusCode())
                    .body(response.getBody());
        } catch (RestClientException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body("{\"error\":\"Error llamando a " + url + "\"}");
        }
    }

    private ResponseEntity<String> forwardPost(String path, String body, String authorization) {
        String url = profesionServiceUrl + path;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (authorization != null && !authorization.isBlank()) {
            headers.set("Authorization", authorization);
        }
        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response =
                    restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            return ResponseEntity
                    .status(response.getStatusCode())
                    .body(response.getBody());
        } catch (RestClientException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body("{\"error\":\"Error llamando a " + url + "\"}");
        }
    }

    private ResponseEntity<String> forwardDelete(String path, String authorization) {
        String url = profesionServiceUrl + path;
        try {
            HttpHeaders headers = new HttpHeaders();
            if (authorization != null && !authorization.isBlank()) {
                headers.set("Authorization", authorization);
            }
            HttpEntity<Void> entity = new HttpEntity<>(headers);

            restTemplate.exchange(url, HttpMethod.DELETE, entity, Void.class);
            return ResponseEntity.noContent().build();
        } catch (RestClientException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body("{\"error\":\"Error llamando a " + url + "\"}");
        }
    }

    // ───────────────────────────── /profesion ─────────────────────────────

    @GetMapping("/profesion")
    public ResponseEntity<String> getAllProfesiones(
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/profesion", authorization);
    }

    @GetMapping("/profesion/{id}")
    public ResponseEntity<String> getProfesionById(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/profesion/" + id, authorization);
    }

    @PostMapping("/profesion/{id}")
    public ResponseEntity<String> saveProfesion(
            @PathVariable String id,
            @RequestBody String body,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardPost("/profesion/" + id, body, authorization);
    }

    @DeleteMapping("/profesion/{id}")
    public ResponseEntity<String> deleteProfesion(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardDelete("/profesion/" + id, authorization);
    }

    // ────────────────────────────── /rubro ──────────────────────────────

    @GetMapping("/rubro")
    public ResponseEntity<String> getAllRubros(
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/rubro", authorization);
    }

    @GetMapping("/rubro/{id}")
    public ResponseEntity<String> getRubroById(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/rubro/" + id, authorization);
    }

    @PostMapping("/rubro/{id}")
    public ResponseEntity<String> saveRubro(
            @PathVariable String id,
            @RequestBody String body,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardPost("/rubro/" + id, body, authorization);
    }

    @DeleteMapping("/rubro/{id}")
    public ResponseEntity<String> deleteRubro(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardDelete("/rubro/" + id, authorization);
    }

    // ─────────────────────── /servicioprofesional ───────────────────────

    @GetMapping("/servicioprofesional")
    public ResponseEntity<String> getAllServiciosProfesionales(
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/servicioprofesional", authorization);
    }

    @GetMapping("/servicioprofesional/{id}")
    public ResponseEntity<String> getServicioProfesionalById(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/servicioprofesional/" + id, authorization);
    }

    @PostMapping("/servicioprofesional/{id}")
    public ResponseEntity<String> saveServicioProfesional(
            @PathVariable String id,
            @RequestBody String body,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardPost("/servicioprofesional/" + id, body, authorization);
    }

    @DeleteMapping("/servicioprofesional/{id}")
    public ResponseEntity<String> deleteServicioProfesional(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardDelete("/servicioprofesional/" + id, authorization);
    }
}
