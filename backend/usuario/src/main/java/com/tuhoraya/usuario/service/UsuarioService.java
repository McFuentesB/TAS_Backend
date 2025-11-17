package com.tuhoraya.usuario.service;

import com.tuhoraya.usuario.model.Usuario;
import com.tuhoraya.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Usuario getById(String id) {
        return repository.findById(id);
    }

    public void save(String id, Usuario obj) {
        repository.save(id, obj);
    }

    public void delete(String id) {
        repository.delete(id);
    }
    
}