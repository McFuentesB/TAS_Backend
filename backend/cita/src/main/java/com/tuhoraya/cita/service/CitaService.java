package com.tuhoraya.cita.service;

import com.tuhoraya.cita.model.Cita;
import com.tuhoraya.cita.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    private final CitaRepository repository;

    public CitaService(CitaRepository repository) {
        this.repository = repository;
    }

    public List<Cita> getAll() {
        return repository.findAll();
    }

    public Cita getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void save(String id, Cita obj) {
        // El ID viene por path, lo seteamos en la entidad antes de guardar
        obj.setId_cita(id);
        repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
