package com.tuhoraya.cita.controller;

import com.tuhoraya.cita.model.Comentarios;
import com.tuhoraya.cita.service.ComentariosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentariosController {

    private final ComentariosService service;

    public ComentariosController(ComentariosService service) {
        this.service = service;
    }

    @GetMapping
    public List<Comentarios> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Comentarios getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("/profesional/{idProfesional}")
    public List<Comentarios> getByProfesional(@PathVariable String idProfesional) {
        return service.getByProfesional(idProfesional);
    }

    @GetMapping("/profesional/{idProfesional}/cliente/{idCliente}")
    public List<Comentarios> getByProfesionalAndCliente(
            @PathVariable String idProfesional,
            @PathVariable String idCliente
    ) {
        return service.getByProfesionalAndCliente(idProfesional, idCliente);
    }

    @PostMapping("/{id}")
    public void save(@PathVariable String id, @RequestBody Comentarios obj) {
        service.save(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
