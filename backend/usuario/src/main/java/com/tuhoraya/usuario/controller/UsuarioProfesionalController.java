package com.tuhoraya.usuario.controller;

import com.tuhoraya.usuario.dto.UsuarioProfesionalDTO;
import com.tuhoraya.usuario.model.UsuarioProfesional;
import com.tuhoraya.usuario.service.UsuarioProfesionalService;
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
    public List<UsuarioProfesionalDTO> getAll() {
        return service.getAllWithUserData();
    }

    @GetMapping("/{id}")
    public UsuarioProfesionalDTO getById(@PathVariable String id) {
        return service.getByIdWithUserData(id);
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
