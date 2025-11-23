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

    // helpers
    private ResponseEntity<String> forwardGet(String path) {
        String url = profesionServiceUrl + path;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return ResponseEntity
                    .status(response.getStatusCode())
                    .body(response.getBody());
        } catch (RestClientException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body("{\"error\":\"Error llamando a " + url + "\"}");
        }
    }

    private ResponseEntity<String> forwardPost(String path, String body) {
        String url = profesionServiceUrl + path;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
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

    private ResponseEntity<String> forwardDelete(String path) {
        String url = profesionServiceUrl + path;
        try {
            restTemplate.delete(url);
            return ResponseEntity.noContent().build();
        } catch (RestClientException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body("{\"error\":\"Error llamando a " + url + "\"}");
        }
    }

    // ───────────────────────────── /profesion ─────────────────────────────

    @GetMapping("/profesion")
    public ResponseEntity<String> getAllProfesiones() {
        return forwardGet("/profesion");
    }

    @GetMapping("/profesion/{id}")
    public ResponseEntity<String> getProfesionById(@PathVariable String id) {
        return forwardGet("/profesion/" + id);
    }

    @PostMapping("/profesion/{id}")
    public ResponseEntity<String> saveProfesion(@PathVariable String id,
                                                @RequestBody String body) {
        return forwardPost("/profesion/" + id, body);
    }

    @DeleteMapping("/profesion/{id}")
    public ResponseEntity<String> deleteProfesion(@PathVariable String id) {
        return forwardDelete("/profesion/" + id);
    }

    // ────────────────────────────── /rubro ──────────────────────────────

    @GetMapping("/rubro")
    public ResponseEntity<String> getAllRubros() {
        return forwardGet("/rubro");
    }

    @GetMapping("/rubro/{id}")
    public ResponseEntity<String> getRubroById(@PathVariable String id) {
        return forwardGet("/rubro/" + id);
    }

    @PostMapping("/rubro/{id}")
    public ResponseEntity<String> saveRubro(@PathVariable String id,
                                            @RequestBody String body) {
        return forwardPost("/rubro/" + id, body);
    }

    @DeleteMapping("/rubro/{id}")
    public ResponseEntity<String> deleteRubro(@PathVariable String id) {
        return forwardDelete("/rubro/" + id);
    }

    // ─────────────────────── /servicioprofesional ───────────────────────

    @GetMapping("/servicioprofesional")
    public ResponseEntity<String> getAllServiciosProfesionales() {
        return forwardGet("/servicioprofesional");
    }

    @GetMapping("/servicioprofesional/{id}")
    public ResponseEntity<String> getServicioProfesionalById(@PathVariable String id) {
        return forwardGet("/servicioprofesional/" + id);
    }

    @PostMapping("/servicioprofesional/{id}")
    public ResponseEntity<String> saveServicioProfesional(@PathVariable String id,
                                                          @RequestBody String body) {
        return forwardPost("/servicioprofesional/" + id, body);
    }

    @DeleteMapping("/servicioprofesional/{id}")
    public ResponseEntity<String> deleteServicioProfesional(@PathVariable String id) {
        return forwardDelete("/servicioprofesional/" + id);
    }
}
