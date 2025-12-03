package com.tuhoraya.cita.controller;


import com.tuhoraya.cita.model.Cita;
import com.tuhoraya.cita.service.CitaService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/cita")
public class CitaController {

    private final CitaService service;

    public CitaController(CitaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cita> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Cita getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("/profesional/{idProfesional}")
    public List<Cita> getByProfesionalId(@PathVariable String idProfesional) {
        return service.getByProfesionalId(idProfesional);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<Cita> getByClienteId(@PathVariable String idCliente) {
        return service.getByClienteId(idCliente);
    }

    @GetMapping("/profesional/{idProfesional}/fecha/{fecha}")
    public List<Cita> getByProfesionalIdAndFecha(
            @PathVariable String idProfesional,
            @PathVariable String fecha) {
        return service.getByProfesionalIdAndFecha(idProfesional, fecha);
    }

    @PostMapping("/{id}")
    public void save(@PathVariable String id, @RequestBody Cita obj) {
        service.save(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}