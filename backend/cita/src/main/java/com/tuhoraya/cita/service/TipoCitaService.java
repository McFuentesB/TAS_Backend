package com.tuhoraya.cita.service;

import com.tuhoraya.cita.model.TipoCita;
import com.tuhoraya.cita.repository.TipoCitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repository.findById(id).orElse(null);
    }

    public void save(String id, TipoCita obj) {
        obj.setId_tipo_cita(id);
        repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
