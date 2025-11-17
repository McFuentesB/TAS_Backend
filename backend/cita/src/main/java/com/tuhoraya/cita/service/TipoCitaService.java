package com.tuhoraya.cita.service;


import com.tuhoraya.cita.model.TipoCita;
import com.tuhoraya.cita.repository.TipoCitaRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TipoCitaService {
    private final TipoCitaRepository repository;

    public TipoCitaService(TipoCitaRepository repository) {
        this.repository = repository;
    }

    public List<TipoCita> getAll() {
        return repository.findAll();
    }

    public TipoCita getById(String id) {
        return repository.findById(id);
    }

    public void save(String id, TipoCita obj) {
        repository.save(id, obj);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}