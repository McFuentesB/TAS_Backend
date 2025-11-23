package com.tuhoraya.bff.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bff")
public class CitaBffController {

    private final RestTemplate restTemplate;

    @Value("${microservices.cita-url}")
    private String citaServiceUrl;

    public CitaBffController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private ResponseEntity<String> forwardGet(String path) {
        String url = citaServiceUrl + path;
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
        String url = citaServiceUrl + path;
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
        String url = citaServiceUrl + path;
        try {
            restTemplate.delete(url);
            return ResponseEntity.noContent().build();
        } catch (RestClientException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body("{\"error\":\"Error llamando a " + url + "\"}");
        }
    }

    // ───────────────────────────── /cita ─────────────────────────────

    @GetMapping("/cita")
    public ResponseEntity<String> getAllCitas() {
        return forwardGet("/cita");
    }

    @GetMapping("/cita/{id}")
    public ResponseEntity<String> getCitaById(@PathVariable String id) {
        return forwardGet("/cita/" + id);
    }

    @PostMapping("/cita/{id}")
    public ResponseEntity<String> saveCita(@PathVariable String id,
                                           @RequestBody String body) {
        return forwardPost("/cita/" + id, body);
    }

    @DeleteMapping("/cita/{id}")
    public ResponseEntity<String> deleteCita(@PathVariable String id) {
        return forwardDelete("/cita/" + id);
    }

    // ────────────────────────── /comentarios ──────────────────────────

    @GetMapping("/comentarios")
    public ResponseEntity<String> getAllComentarios() {
        return forwardGet("/comentarios");
    }

    @GetMapping("/comentarios/{id}")
    public ResponseEntity<String> getComentarioById(@PathVariable String id) {
        return forwardGet("/comentarios/" + id);
    }

    @PostMapping("/comentarios/{id}")
    public ResponseEntity<String> saveComentario(@PathVariable String id,
                                                 @RequestBody String body) {
        return forwardPost("/comentarios/" + id, body);
    }

    @DeleteMapping("/comentarios/{id}")
    public ResponseEntity<String> deleteComentario(@PathVariable String id) {
        return forwardDelete("/comentarios/" + id);
    }

    // ──────────────────────────── /historial ────────────────────────────

    @GetMapping("/historial")
    public ResponseEntity<String> getAllHistorial() {
        return forwardGet("/historial");
    }

    @GetMapping("/historial/{id}")
    public ResponseEntity<String> getHistorialById(@PathVariable String id) {
        return forwardGet("/historial/" + id);
    }

    @PostMapping("/historial/{id}")
    public ResponseEntity<String> saveHistorial(@PathVariable String id,
                                                @RequestBody String body) {
        return forwardPost("/historial/" + id, body);
    }

    @DeleteMapping("/historial/{id}")
    public ResponseEntity<String> deleteHistorial(@PathVariable String id) {
        return forwardDelete("/historial/" + id);
    }

    // ───────────────────────────── /pagos ─────────────────────────────

    @GetMapping("/pagos")
    public ResponseEntity<String> getAllPagos() {
        return forwardGet("/pagos");
    }

    @GetMapping("/pagos/{id}")
    public ResponseEntity<String> getPagoById(@PathVariable String id) {
        return forwardGet("/pagos/" + id);
    }

    @PostMapping("/pagos/{id}")
    public ResponseEntity<String> savePago(@PathVariable String id,
                                           @RequestBody String body) {
        return forwardPost("/pagos/" + id, body);
    }

    @DeleteMapping("/pagos/{id}")
    public ResponseEntity<String> deletePago(@PathVariable String id) {
        return forwardDelete("/pagos/" + id);
    }

    // ─────────────────────────── /tipocita ───────────────────────────

    @GetMapping("/tipocita")
    public ResponseEntity<String> getAllTipoCita() {
        return forwardGet("/tipocita");
    }

    @GetMapping("/tipocita/{id}")
    public ResponseEntity<String> getTipoCitaById(@PathVariable String id) {
        return forwardGet("/tipocita/" + id);
    }

    @PostMapping("/tipocita/{id}")
    public ResponseEntity<String> saveTipoCita(@PathVariable String id,
                                               @RequestBody String body) {
        return forwardPost("/tipocita/" + id, body);
    }

    @DeleteMapping("/tipocita/{id}")
    public ResponseEntity<String> deleteTipoCita(@PathVariable String id) {
        return forwardDelete("/tipocita/" + id);
    }
}
