package com.tuhoraya.cita.controller;

import com.tuhoraya.cita.model.TipoCita;
import com.tuhoraya.cita.service.TipoCitaService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/tipocita")
public class TipoCitaController {

    private final TipoCitaService service;

    public TipoCitaController(TipoCitaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoCita> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TipoCita getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/{id}")
    public void save(@PathVariable String id, @RequestBody TipoCita obj) {
        service.save(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}