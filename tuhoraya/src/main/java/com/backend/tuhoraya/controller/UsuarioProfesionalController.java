package com.backend.tuhoraya.controller;

import com.backend.tuhoraya.model.UsuarioProfesional;
import com.backend.tuhoraya.service.UsuarioProfesionalService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/usuarioprofesional")
public class UsuarioProfesionalController {

    private final UsuarioProfesionalService service;

    public UsuarioProfesionalController(UsuarioProfesionalService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioProfesional> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UsuarioProfesional getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/{id}")
    public void save(@PathVariable String id, @RequestBody UsuarioProfesional obj) {
        service.save(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}