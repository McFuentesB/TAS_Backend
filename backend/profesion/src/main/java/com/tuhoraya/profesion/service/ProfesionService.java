package com.tuhoraya.profesion.service;

import com.tuhoraya.profesion.model.Profesion;
import com.tuhoraya.profesion.repository.ProfesionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesionService {

    private final ProfesionRepository repository;

    public ProfesionService(ProfesionRepository repository) {
        this.repository = repository;
    }

    public List<Profesion> getAll() {
        return repository.findAll();
    }

    public Optional<Profesion> getById(String id) {
        return repository.findById(id);
    }

    public Profesion save(String id, Profesion obj) {
        // usamos el id del path como id_profesion
        obj.setId_profesion(id);
        return repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
