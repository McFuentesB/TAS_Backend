package com.backend.tuhoraya.service;

import com.backend.tuhoraya.model.Profesion;
import com.backend.tuhoraya.repository.ProfesionRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProfesionService {
    private final ProfesionRepository repository;

    public ProfesionService(ProfesionRepository repository) {
        this.repository = repository;
    }

    public List<Profesion> getAll() {
        return repository.findAll();
    }

    public Profesion getById(String id) {
        return repository.findById(id);
    }

    public void save(String id, Profesion obj) {
        repository.save(id, obj);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}
