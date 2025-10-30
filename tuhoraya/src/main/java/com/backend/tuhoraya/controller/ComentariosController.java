package com.backend.tuhoraya.controller;

import com.backend.tuhoraya.model.Comentarios;
import com.backend.tuhoraya.service.ComentariosService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/comentarios")
public class ComentariosController {

    private final ComentariosService service;

    public ComentariosController(ComentariosService service) {
        this.service = service;
    }

    @GetMapping
    public List<Comentarios> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Comentarios getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/{id}")
    public void save(@PathVariable String id, @RequestBody Comentarios obj) {
        service.save(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}