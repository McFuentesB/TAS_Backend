package com.tuhoraya.usuario.service;

import com.tuhoraya.usuario.model.Rol;
import com.tuhoraya.usuario.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    private final RolRepository repository;

    public RolService(RolRepository repository) {
        this.repository = repository;
    }

    public List<Rol> getAll() {
        return repository.findAll();
    }

    public Optional<Rol> getById(String id) {
        return repository.findById(id);
    }

    public Rol save(String id, Rol obj) {
        // Ajusta el setter según tu entidad
        obj.setId_rol(id);
        return repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
