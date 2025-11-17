package com.tuhoraya.profesion.controller;


import com.tuhoraya.profesion.model.Profesion;
import com.tuhoraya.profesion.service.ProfesionService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

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
    public Profesion getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/{id}")
    public void save(@PathVariable String id, @RequestBody Profesion obj) {
        service.save(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}