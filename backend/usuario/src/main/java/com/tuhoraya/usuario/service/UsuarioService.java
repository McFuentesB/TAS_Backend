package com.tuhoraya.usuario.service;

import com.tuhoraya.usuario.model.Usuario;
import com.tuhoraya.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Optional<Usuario> getById(String id) {
        return repository.findById(id);
    }

    public Usuario save(String id, Usuario obj) {
        // Ajusta el setter según tu entidad
        obj.setId_usuario(id);
        return repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
