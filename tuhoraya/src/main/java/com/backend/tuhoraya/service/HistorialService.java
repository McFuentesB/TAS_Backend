package com.backend.tuhoraya.service;


import com.backend.tuhoraya.model.Historial;
import com.backend.tuhoraya.repository.HistorialRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class HistorialService {
    private final HistorialRepository repository;

    public HistorialService(HistorialRepository repository) {
        this.repository = repository;
    }

    public List<Historial> getAll() {
        return repository.findAll();
    }

    public Historial getById(String id) {
        return repository.findById(id);
    }

    public void save(String id, Historial obj) {
        repository.save(id, obj);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}