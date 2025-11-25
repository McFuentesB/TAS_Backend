package com.tuhoraya.usuario.controller;

import com.tuhoraya.usuario.model.UsuarioCliente;
import com.tuhoraya.usuario.service.UsuarioClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuariocliente")
public class UsuarioClienteController {

    private final UsuarioClienteService service;

    public UsuarioClienteController(UsuarioClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioCliente> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioCliente> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public ResponseEntity<UsuarioCliente> save(
            @PathVariable String id,
            @RequestBody UsuarioCliente obj
    ) {
        UsuarioCliente saved = service.save(id, obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
