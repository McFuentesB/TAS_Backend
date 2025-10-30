package com.backend.tuhoraya.service;


import com.backend.tuhoraya.model.Rol;
import com.backend.tuhoraya.repository.RolRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RolService {
    private final RolRepository repository;

    public RolService(RolRepository repository) {
        this.repository = repository;
    }

    public List<Rol> getAll() {
        return repository.findAll();
    }

    public Rol getById(String id) {
        return repository.findById(id);
    }

    public void save(String id, Rol obj) {
        repository.save(id, obj);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}