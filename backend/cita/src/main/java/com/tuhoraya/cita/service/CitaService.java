package com.tuhoraya.cita.service;



import com.tuhoraya.cita.model.Cita;
import com.tuhoraya.cita.repository.CitaRepository;
import org.springframework.stereotype.Service;
import java.util.*;

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
        return repository.findById(id);
    }

    public void save(String id, Cita obj) {
        repository.save(id, obj);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}