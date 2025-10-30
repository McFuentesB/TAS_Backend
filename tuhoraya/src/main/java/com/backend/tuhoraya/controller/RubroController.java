package com.backend.tuhoraya.controller;

import com.backend.tuhoraya.model.Rubro;
import com.backend.tuhoraya.service.RubroService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

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
    public Rubro getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/{id}")
    public void save(@PathVariable String id, @RequestBody Rubro obj) {
        service.save(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}