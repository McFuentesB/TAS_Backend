package com.backend.tuhoraya.controller;

import com.backend.tuhoraya.model.Historial;
import com.backend.tuhoraya.service.HistorialService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/historial")
public class HistorialController {

    private final HistorialService service;

    public HistorialController(HistorialService service) {
        this.service = service;
    }

    @GetMapping
    public List<Historial> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Historial getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/{id}")
    public void save(@PathVariable String id, @RequestBody Historial obj) {
        service.save(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}