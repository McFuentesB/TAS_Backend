package com.tuhoraya.bff.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bff")
public class UsuarioBffController {

    private final RestTemplate restTemplate;

    @Value("${microservices.usuario-url}")
    private String usuarioServiceUrl;

    public UsuarioBffController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // ─────────────────────────── helpers ───────────────────────────

    private ResponseEntity<String> forwardGet(String path, String authorization) {
        String url = usuarioServiceUrl + path;
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
        String url = usuarioServiceUrl + path;
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
        String url = usuarioServiceUrl + path;
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

    // ─────────────────────────── /usuario ───────────────────────────

    @GetMapping("/usuario")
    public ResponseEntity<String> getAllUsuarios(
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/usuario", authorization);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<String> getUsuarioById(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/usuario/" + id, authorization);
    }

    @PostMapping("/usuario/{id}")
    public ResponseEntity<String> saveUsuario(
            @PathVariable String id,
            @RequestBody String body,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardPost("/usuario/" + id, body, authorization);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<String> deleteUsuario(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardDelete("/usuario/" + id, authorization);
    }

    // ──────────────────────── /usuariocliente ────────────────────────

    @GetMapping("/usuariocliente")
    public ResponseEntity<String> getAllUsuarioCliente(
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/usuariocliente", authorization);
    }

    @GetMapping("/usuariocliente/{id}")
    public ResponseEntity<String> getUsuarioClienteById(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/usuariocliente/" + id, authorization);
    }

    @PostMapping("/usuariocliente/{id}")
    public ResponseEntity<String> saveUsuarioCliente(
            @PathVariable String id,
            @RequestBody String body,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardPost("/usuariocliente/" + id, body, authorization);
    }

    @DeleteMapping("/usuariocliente/{id}")
    public ResponseEntity<String> deleteUsuarioCliente(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardDelete("/usuariocliente/" + id, authorization);
    }

    // ─────────────────────── /usuarioprofesional ───────────────────────

    @GetMapping("/usuarioprofesional")
    public ResponseEntity<String> getAllUsuarioProfesional(
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/usuarioprofesional", authorization);
    }

    @GetMapping("/usuarioprofesional/{id}")
    public ResponseEntity<String> getUsuarioProfesionalById(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/usuarioprofesional/" + id, authorization);
    }

    @PostMapping("/usuarioprofesional/{id}")
    public ResponseEntity<String> saveUsuarioProfesional(
            @PathVariable String id,
            @RequestBody String body,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardPost("/usuarioprofesional/" + id, body, authorization);
    }

    @DeleteMapping("/usuarioprofesional/{id}")
    public ResponseEntity<String> deleteUsuarioProfesional(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardDelete("/usuarioprofesional/" + id, authorization);
    }

    // ───────────────────────────── /rol ─────────────────────────────

    @GetMapping("/rol")
    public ResponseEntity<String> getAllRoles(
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/rol", authorization);
    }

    @GetMapping("/rol/{id}")
    public ResponseEntity<String> getRolById(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardGet("/rol/" + id, authorization);
    }

    @PostMapping("/rol/{id}")
    public ResponseEntity<String> saveRol(
            @PathVariable String id,
            @RequestBody String body,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardPost("/rol/" + id, body, authorization);
    }

    @DeleteMapping("/rol/{id}")
    public ResponseEntity<String> deleteRol(
            @PathVariable String id,
            @RequestHeader(name = "Authorization", required = false) String authorization) {
        return forwardDelete("/rol/" + id, authorization);
    }
}
