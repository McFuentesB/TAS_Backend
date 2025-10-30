package com.backend.tuhoraya.service;

import com.backend.tuhoraya.model.Pagos;
import com.backend.tuhoraya.repository.PagosRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PagosService {
    private final PagosRepository repository;

    public PagosService(PagosRepository repository) {
        this.repository = repository;
    }

    public List<Pagos> getAll() {
        return repository.findAll();
    }

    public Pagos getById(String id) {
        return repository.findById(id);
    }

    public void save(String id, Pagos obj) {
        repository.save(id, obj);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}