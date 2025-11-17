package com.tuhoraya.usuario.controller;


import com.tuhoraya.usuario.model.Rol;
import com.tuhoraya.usuario.service.RolService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

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
    public Rol getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/{id}")
    public void save(@PathVariable String id, @RequestBody Rol obj) {
        service.save(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}