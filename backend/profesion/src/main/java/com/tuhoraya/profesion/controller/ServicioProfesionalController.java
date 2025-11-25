package com.tuhoraya.profesion.controller;

import com.tuhoraya.profesion.model.ServicioProfesional;
import com.tuhoraya.profesion.service.ServicioProfesionalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicioprofesional")
public class ServicioProfesionalController {

    private final ServicioProfesionalService service;

    public ServicioProfesionalController(ServicioProfesionalService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServicioProfesional> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioProfesional> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public ResponseEntity<ServicioProfesional> save(
            @PathVariable String id,
            @RequestBody ServicioProfesional obj
    ) {
        ServicioProfesional saved = service.save(id, obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
