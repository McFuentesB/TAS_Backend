package com.tuhoraya.cita.service;

import com.tuhoraya.cita.model.Historial;
import com.tuhoraya.cita.repository.HistorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialService {

    private final HistorialRepository repository;

    public HistorialService(HistorialRepository repository) {
        this.repository = repository;
    }

    public List<Historial> getAll() {
        return repository.findAll();
    }

    public Historial getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void save(String id, Historial obj) {
        obj.setId_historial(id);
        repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
