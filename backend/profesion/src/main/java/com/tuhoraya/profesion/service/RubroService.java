package com.tuhoraya.profesion.service;

import com.tuhoraya.profesion.model.Rubro;
import com.tuhoraya.profesion.repository.RubroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RubroService {

    private final RubroRepository repository;

    public RubroService(RubroRepository repository) {
        this.repository = repository;
    }

    public List<Rubro> getAll() {
        return repository.findAll();
    }

    public Optional<Rubro> getById(String id) {
        return repository.findById(id);
    }

    public Rubro save(String id, Rubro obj) {
        // usar el id del path como PK
        obj.setId_rubro(id);
        return repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
