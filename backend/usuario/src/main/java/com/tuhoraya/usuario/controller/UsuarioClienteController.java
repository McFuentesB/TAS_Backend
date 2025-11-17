package com.tuhoraya.usuario.controller;

import com.tuhoraya.usuario.model.UsuarioCliente;
import com.tuhoraya.usuario.service.UsuarioClienteService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/usuariocliente")
public class UsuarioClienteController {

    private final UsuarioClienteService service;

    public UsuarioClienteController(UsuarioClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioCliente> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UsuarioCliente getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/{id}")
    public void save(@PathVariable String id, @RequestBody UsuarioCliente obj) {
        service.save(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}