package com.backend.tuhoraya.service;

import com.backend.tuhoraya.model.TipoCita;
import com.backend.tuhoraya.repository.TipoCitaRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TipoCitaService {
    private final TipoCitaRepository repository;

    public TipoCitaService(TipoCitaRepository repository) {
        this.repository = repository;
    }

    public List<TipoCita> getAll() {
        return repository.findAll();
    }

    public TipoCita getById(String id) {
        return repository.findById(id);
    }

    public void save(String id, TipoCita obj) {
        repository.save(id, obj);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}