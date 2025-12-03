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

    public List<Cita> getByProfesionalId(String idProfesional) {
        return repository.findByProfesionalId(idProfesional);
    }

    public List<Cita> getByClienteId(String idCliente) {
        return repository.findByClienteId(idCliente);
    }

    public List<Cita> getByProfesionalIdAndFecha(String idProfesional, String fecha) {
        return repository.findByProfesionalIdAndFecha(idProfesional, fecha);
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
