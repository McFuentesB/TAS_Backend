package com.tuhoraya.cita.service;

import com.tuhoraya.cita.model.Comentarios;
import com.tuhoraya.cita.repository.ComentariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repository.findById(id).orElse(null);
    }

    public void save(String id, Comentarios obj) {
        obj.setId_comentario(id);   // el id viene por path
        repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
