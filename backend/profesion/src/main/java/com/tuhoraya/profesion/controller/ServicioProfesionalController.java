package com.tuhoraya.profesion.controller;


import com.tuhoraya.profesion.model.ServicioProfesional;
import com.tuhoraya.profesion.service.ServicioProfesionalService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/servicioprofesional")
public class ServicioProfesionalController {

    private final ServicioProfesionalService service;

    public ServicioProfesionalController(ServicioProfesionalService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServicioProfesional> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ServicioProfesional getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping("/{id}")
    public void save(@PathVariable String id, @RequestBody ServicioProfesional obj) {
        service.save(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}