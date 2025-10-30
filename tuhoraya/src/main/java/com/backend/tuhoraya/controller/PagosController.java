package com.backend.tuhoraya.controller;

import com.backend.tuhoraya.model.Pagos;
import com.backend.tuhoraya.service.PagosService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/pagos")
public class PagosController {

    private final PagosService service;

    public PagosController(PagosService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pagos> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Pagos getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/{id}")
    public void save(@PathVariable String id, @RequestBody Pagos obj) {
        service.save(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}