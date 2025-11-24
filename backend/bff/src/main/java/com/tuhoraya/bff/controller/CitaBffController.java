package com.tuhoraya.bff.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bff")
public class CitaBffController {

    private static final Logger log = LoggerFactory.getLogger(CitaBffController.class);

    private final RestTemplate restTemplate;

    @Value("${microservices.cita-url}")
    private String citaServiceUrl;

    public CitaBffController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // ───────────────────────── helpers ─────────────────────────

    private ResponseEntity<String> forwardGet(String path, String authHeader) {
        String url = citaServiceUrl + path;

        HttpHeaders headers = new HttpHeaders();
        if (authHeader != null && !authHeader.isBlank()) {
            headers.set(HttpHeaders.AUTHORIZATION, authHeader);
        }

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response =
                    restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return ResponseEntity
                    .status(response.getStatusCode())
                    .body(response.getBody());
        } catch (RestClientException e) {
            log.error("Error llamando a {}: {}", url, e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body("{\"error\":\"Error llamando a " + url + "\"}");
        }
    }

    private ResponseEntity<String> forwardPost(String path, String body, String authHeader) {
        String url = citaServiceUrl + path;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (authHeader != null && !authHeader.isBlank()) {
            headers.set(HttpHeaders.AUTHORIZATION, authHeader);
        }

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response =
                    restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            return ResponseEntity
                    .status(response.getStatusCode())
                    .body(response.getBody());
        } catch (RestClientException e) {
            log.error("Error llamando a {}: {}", url, e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body("{\"error\":\"Error llamando a " + url + "\"}");
        }
    }

    private ResponseEntity<String> forwardDelete(String path, String authHeader) {
        String url = citaServiceUrl + path;

        HttpHeaders headers = new HttpHeaders();
        if (authHeader != null && !authHeader.isBlank()) {
            headers.set(HttpHeaders.AUTHORIZATION, authHeader);
        }

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<Void> response =
                    restTemplate.exchange(url, HttpMethod.DELETE, entity, Void.class);
            return ResponseEntity.status(response.getStatusCode()).build();
        } catch (RestClientException e) {
            log.error("Error llamando a {}: {}", url, e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body("{\"error\":\"Error llamando a " + url + "\"}");
        }
    }

    // ───────────────────────────── /cita ─────────────────────────────

    @GetMapping("/cita")
    public ResponseEntity<String> getAllCitas(
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/cita", authorization);
    }

    @GetMapping("/cita/{id}")
    public ResponseEntity<String> getCitaById(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/cita/" + id, authorization);
    }

    @PostMapping("/cita/{id}")
    public ResponseEntity<String> saveCita(
            @PathVariable String id,
            @RequestBody String body,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardPost("/cita/" + id, body, authorization);
    }

    @DeleteMapping("/cita/{id}")
    public ResponseEntity<String> deleteCita(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardDelete("/cita/" + id, authorization);
    }

    // ───────────────────────────── /pagos ─────────────────────────────
// ───────────────────────────── /pagos ─────────────────────────────

@GetMapping("/pagos")
public ResponseEntity<String> getAllPagos(
        @RequestHeader(name = "Authorization", required = false) String authorization) {
    return forwardGet("/pagos", authorization);
}

@GetMapping("/pagos/{id}")
public ResponseEntity<String> getPagoById(
        @PathVariable String id,
        @RequestHeader(name = "Authorization", required = false) String authorization) {
    return forwardGet("/pagos/" + id, authorization);
}

@PostMapping("/pagos/{id}")
public ResponseEntity<String> savePago(
        @PathVariable String id,
        @RequestBody String body,
        @RequestHeader(name = "Authorization", required = false) String authorization) {
    return forwardPost("/pagos/" + id, body, authorization);
}

@DeleteMapping("/pagos/{id}")
public ResponseEntity<String> deletePago(
        @PathVariable String id,
        @RequestHeader(name = "Authorization", required = false) String authorization) {
    return forwardDelete("/pagos/" + id, authorization);
}

// ─────────────────────────── /tipocita ───────────────────────────

@GetMapping("/tipocita")
public ResponseEntity<String> getAllTipoCita(
        @RequestHeader(name = "Authorization", required = false) String authorization) {
    return forwardGet("/tipocita", authorization);
}

@GetMapping("/tipocita/{id}")
public ResponseEntity<String> getTipoCitaById(
        @PathVariable String id,
        @RequestHeader(name = "Authorization", required = false) String authorization) {
    return forwardGet("/tipocita/" + id, authorization);
}

@PostMapping("/tipocita/{id}")
public ResponseEntity<String> saveTipoCita(
        @PathVariable String id,
        @RequestBody String body,
        @RequestHeader(name = "Authorization", required = false) String authorization) {
    return forwardPost("/tipocita/" + id, body, authorization);
}

@DeleteMapping("/tipocita/{id}")
public ResponseEntity<String> deleteTipoCita(
        @PathVariable String id,
        @RequestHeader(name = "Authorization", required = false) String authorization) {
    return forwardDelete("/tipocita/" + id, authorization);
}

}
