package com.tuhoraya.usuario.controller;


import com.tuhoraya.usuario.model.Usuario;
import com.tuhoraya.usuario.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/{id}")
    public void save(@PathVariable String id, @RequestBody Usuario obj) {
        service.save(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}