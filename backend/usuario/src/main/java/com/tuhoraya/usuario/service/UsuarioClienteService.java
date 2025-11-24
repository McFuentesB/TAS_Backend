package com.tuhoraya.usuario.service;

import com.tuhoraya.usuario.model.UsuarioCliente;
import com.tuhoraya.usuario.repository.UsuarioClienteRepository;
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
        return repository.findById(id).orElse(null);
    }

    public void save(String id, UsuarioCliente obj) {
        obj.setId_usuario_cliente(id);
        repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
