package com.tuhoraya.usuario.service;

import com.tuhoraya.usuario.model.UsuarioProfesional;
import com.tuhoraya.usuario.repository.UsuarioProfesionalRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UsuarioProfesionalService {
    private final UsuarioProfesionalRepository repository;

    public UsuarioProfesionalService(UsuarioProfesionalRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioProfesional> getAll() {
        return repository.findAll();
    }

    public UsuarioProfesional getById(String id) {
        return repository.findById(id);
    }

    public void save(String id, UsuarioProfesional obj) {
        repository.save(id, obj);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}
