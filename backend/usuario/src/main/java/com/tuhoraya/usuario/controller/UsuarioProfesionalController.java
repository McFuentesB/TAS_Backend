package com.tuhoraya.usuario.controller;

import com.tuhoraya.usuario.dto.UsuarioProfesionalDTO;
import com.tuhoraya.usuario.model.UsuarioProfesional;
import com.tuhoraya.usuario.service.UsuarioProfesionalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<UsuarioProfesionalDTO> getById(@PathVariable String id) {
        UsuarioProfesionalDTO dto = service.getByIdWithUserData(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<UsuarioProfesional> save(
            @PathVariable String id,
            @RequestBody UsuarioProfesional obj
    ) {
        UsuarioProfesional saved = service.save(id, obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
