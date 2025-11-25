package com.tuhoraya.usuario.controller;

import com.tuhoraya.usuario.model.Rol;
import com.tuhoraya.usuario.service.RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {

    private final RolService service;

    public RolController(RolService service) {
        this.service = service;
    }

    @GetMapping
    public List<Rol> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok) // 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404
    }

    @PostMapping("/{id}")
    public ResponseEntity<Rol> save(
            @PathVariable String id,
            @RequestBody Rol obj
    ) {
        Rol saved = service.save(id, obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // 204
    }
}
