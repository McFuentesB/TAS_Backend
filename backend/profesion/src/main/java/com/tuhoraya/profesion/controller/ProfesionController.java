package com.tuhoraya.profesion.controller;

import com.tuhoraya.profesion.model.Profesion;
import com.tuhoraya.profesion.service.ProfesionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesion")
public class ProfesionController {

    private final ProfesionService service;

    public ProfesionController(ProfesionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Profesion> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesion> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)                       // 200 + body
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404
    }

    @PostMapping("/{id}")
    public ResponseEntity<Profesion> save(
            @PathVariable String id,
            @RequestBody Profesion obj
    ) {
        Profesion saved = service.save(id, obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
