package com.tuhoraya.usuario.controller;

import com.tuhoraya.usuario.dto.LoginRequest;
import com.tuhoraya.usuario.dto.LoginResponse;
import com.tuhoraya.usuario.dto.AzureAdSyncRequest;
import com.tuhoraya.usuario.dto.OnboardingUpdateRequest;
import com.tuhoraya.usuario.model.Usuario;
import com.tuhoraya.usuario.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable String id) {
        Usuario usuario = service.getById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Usuario> save(
            @PathVariable String id,
            @RequestBody Usuario obj
    ) {
        Usuario saved = service.save(id, obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = service.login(request);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @PostMapping("/azure-sync")
    public ResponseEntity<LoginResponse> syncAzureAdUser(@RequestBody AzureAdSyncRequest request) {
        LoginResponse response = service.syncAzureAdUser(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/complete-onboarding")
    public ResponseEntity<LoginResponse> completeOnboarding(
            @PathVariable String id,
            @RequestBody OnboardingUpdateRequest request
    ) {
        LoginResponse response = service.completeOnboarding(id, request);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
