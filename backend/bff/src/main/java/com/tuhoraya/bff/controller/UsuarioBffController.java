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

    private ResponseEntity<String> forwardGet(String path) {
        String url = usuarioServiceUrl + path;
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
        String url = usuarioServiceUrl + path;
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
        String url = usuarioServiceUrl + path;
        try {
            restTemplate.delete(url);
            return ResponseEntity.noContent().build();
        } catch (RestClientException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body("{\"error\":\"Error llamando a " + url + "\"}");
        }
    }

    // ─────────────────────────── /usuario ───────────────────────────

    @GetMapping("/usuario")
    public ResponseEntity<String> getAllUsuarios() {
        return forwardGet("/usuario");
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<String> getUsuarioById(@PathVariable String id) {
        return forwardGet("/usuario/" + id);
    }

    @PostMapping("/usuario/{id}")
    public ResponseEntity<String> saveUsuario(@PathVariable String id,
                                              @RequestBody String body) {
        return forwardPost("/usuario/" + id, body);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable String id) {
        return forwardDelete("/usuario/" + id);
    }

    // ──────────────────────── /usuariocliente ────────────────────────

    @GetMapping("/usuariocliente")
    public ResponseEntity<String> getAllUsuarioCliente() {
        return forwardGet("/usuariocliente");
    }

    @GetMapping("/usuariocliente/{id}")
    public ResponseEntity<String> getUsuarioClienteById(@PathVariable String id) {
        return forwardGet("/usuariocliente/" + id);
    }

    @PostMapping("/usuariocliente/{id}")
    public ResponseEntity<String> saveUsuarioCliente(@PathVariable String id,
                                                     @RequestBody String body) {
        return forwardPost("/usuariocliente/" + id, body);
    }

    @DeleteMapping("/usuariocliente/{id}")
    public ResponseEntity<String> deleteUsuarioCliente(@PathVariable String id) {
        return forwardDelete("/usuariocliente/" + id);
    }

    // ─────────────────────── /usuarioprofesional ───────────────────────

    @GetMapping("/usuarioprofesional")
    public ResponseEntity<String> getAllUsuarioProfesional() {
        return forwardGet("/usuarioprofesional");
    }

    @GetMapping("/usuarioprofesional/{id}")
    public ResponseEntity<String> getUsuarioProfesionalById(@PathVariable String id) {
        return forwardGet("/usuarioprofesional/" + id);
    }

    @PostMapping("/usuarioprofesional/{id}")
    public ResponseEntity<String> saveUsuarioProfesional(@PathVariable String id,
                                                         @RequestBody String body) {
        return forwardPost("/usuarioprofesional/" + id, body);
    }

    @DeleteMapping("/usuarioprofesional/{id}")
    public ResponseEntity<String> deleteUsuarioProfesional(@PathVariable String id) {
        return forwardDelete("/usuarioprofesional/" + id);
    }

    // ───────────────────────────── /rol ─────────────────────────────

    @GetMapping("/rol")
    public ResponseEntity<String> getAllRoles() {
        return forwardGet("/rol");
    }

    @GetMapping("/rol/{id}")
    public ResponseEntity<String> getRolById(@PathVariable String id) {
        return forwardGet("/rol/" + id);
    }

    @PostMapping("/rol/{id}")
    public ResponseEntity<String> saveRol(@PathVariable String id,
                                          @RequestBody String body) {
        return forwardPost("/rol/" + id, body);
    }

    @DeleteMapping("/rol/{id}")
    public ResponseEntity<String> deleteRol(@PathVariable String id) {
        return forwardDelete("/rol/" + id);
    }
}
