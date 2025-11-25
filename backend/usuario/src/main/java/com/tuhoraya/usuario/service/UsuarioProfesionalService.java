package com.tuhoraya.usuario.service;

import com.tuhoraya.usuario.model.UsuarioProfesional;
import com.tuhoraya.usuario.repository.UsuarioProfesionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioProfesionalService {

    private final UsuarioProfesionalRepository repository;

    public UsuarioProfesionalService(UsuarioProfesionalRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioProfesional> getAll() {
        return repository.findAll();
    }

    public Optional<UsuarioProfesional> getById(String id) {
        return repository.findById(id);
    }

    public UsuarioProfesional save(String id, UsuarioProfesional obj) {
        // Ajusta el setter según tu entidad
        obj.setId_usuario_profesional(id);
        return repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
