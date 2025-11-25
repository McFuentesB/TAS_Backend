package com.tuhoraya.profesion.service;

import com.tuhoraya.profesion.model.ServicioProfesional;
import com.tuhoraya.profesion.repository.ServicioProfesionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioProfesionalService {

    private final ServicioProfesionalRepository repository;

    public ServicioProfesionalService(ServicioProfesionalRepository repository) {
        this.repository = repository;
    }

    public List<ServicioProfesional> getAll() {
        return repository.findAll();
    }

    public Optional<ServicioProfesional> getById(String id) {
        return repository.findById(id);
    }

    public ServicioProfesional save(String id, ServicioProfesional obj) {
        // usar el id del path como PK
        obj.setId_servicio_profesional(id);
        return repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
