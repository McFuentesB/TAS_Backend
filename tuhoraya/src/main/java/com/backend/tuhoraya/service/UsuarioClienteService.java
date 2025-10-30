package com.backend.tuhoraya.service;

import com.backend.tuhoraya.model.UsuarioCliente;
import com.backend.tuhoraya.repository.UsuarioClienteRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UsuarioClienteService {
    private final UsuarioClienteRepository repository;

    public UsuarioClienteService(UsuarioClienteRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioCliente> getAll() {
        return repository.findAll();
    }

    public UsuarioCliente getById(String id) {
        return repository.findById(id);
    }

    public void save(String id, UsuarioCliente obj) {
        repository.save(id, obj);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}