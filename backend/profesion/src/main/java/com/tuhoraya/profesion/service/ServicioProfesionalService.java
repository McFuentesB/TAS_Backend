package com.tuhoraya.profesion.service;

import com.tuhoraya.profesion.model.ServicioProfesional;
import com.tuhoraya.profesion.repository.ServicioProfesionalRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ServicioProfesionalService {
    private final ServicioProfesionalRepository repository;

    public ServicioProfesionalService(ServicioProfesionalRepository repository) {
        this.repository = repository;
    }

    public List<ServicioProfesional> getAll() {
        return repository.findAll();
    }

    public ServicioProfesional getById(String id) {
        return repository.findById(id);
    }

    public void save(String id, ServicioProfesional obj) {
        repository.save(id, obj);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}