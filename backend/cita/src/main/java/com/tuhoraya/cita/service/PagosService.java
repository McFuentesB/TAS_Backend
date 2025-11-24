package com.tuhoraya.cita.service;

import com.tuhoraya.cita.model.Pagos;
import com.tuhoraya.cita.repository.PagosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagosService {

    private final PagosRepository repository;

    public PagosService(PagosRepository repository) {
        this.repository = repository;
    }

    public List<Pagos> getAll() {
        return repository.findAll();
    }

    public Pagos getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void save(String id, Pagos obj) {
        obj.setId_pago(id);
        repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
