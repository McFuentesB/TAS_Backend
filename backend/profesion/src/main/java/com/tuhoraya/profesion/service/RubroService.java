package com.tuhoraya.profesion.service;

import com.tuhoraya.profesion.model.Rubro;
import com.tuhoraya.profesion.repository.RubroRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RubroService {
    private final RubroRepository repository;

    public RubroService(RubroRepository repository) {
        this.repository = repository;
    }

    public List<Rubro> getAll() {
        return repository.findAll();
    }

    public Rubro getById(String id) {
        return repository.findById(id);
    }

    public void save(String id, Rubro obj) {
        repository.save(id, obj);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}