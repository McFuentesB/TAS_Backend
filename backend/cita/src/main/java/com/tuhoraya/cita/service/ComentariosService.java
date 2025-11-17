package com.tuhoraya.cita.service;


import com.tuhoraya.cita.model.Comentarios;
import com.tuhoraya.cita.repository.ComentariosRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ComentariosService {
    private final ComentariosRepository repository;

    public ComentariosService(ComentariosRepository repository) {
        this.repository = repository;
    }

    public List<Comentarios> getAll() {
        return repository.findAll();
    }

    public Comentarios getById(String id) {
        return repository.findById(id);
    }

    public void save(String id, Comentarios obj) {
        repository.save(id, obj);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}

