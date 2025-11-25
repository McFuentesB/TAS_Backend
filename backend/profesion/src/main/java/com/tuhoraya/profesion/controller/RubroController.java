package com.tuhoraya.profesion.controller;

import com.tuhoraya.profesion.model.Rubro;
import com.tuhoraya.profesion.service.RubroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rubro")
public class RubroController {

    private final RubroService service;

    public RubroController(RubroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Rubro> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rubro> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)                    // 200 con body
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404
    }

    @PostMapping("/{id}")
    public ResponseEntity<Rubro> save(
            @PathVariable String id,
            @RequestBody Rubro obj
    ) {
        Rubro saved = service.save(id, obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
