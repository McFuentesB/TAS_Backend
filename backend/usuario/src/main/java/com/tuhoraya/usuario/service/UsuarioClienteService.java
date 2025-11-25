package com.tuhoraya.usuario.service;

import com.tuhoraya.usuario.model.UsuarioCliente;
import com.tuhoraya.usuario.repository.UsuarioClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioClienteService {

    private final UsuarioClienteRepository repository;

    public UsuarioClienteService(UsuarioClienteRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioCliente> getAll() {
        return repository.findAll();
    }

    public Optional<UsuarioCliente> getById(String id) {
        return repository.findById(id);
    }

    public UsuarioCliente save(String id, UsuarioCliente obj) {
        // Ajusta el setter según tu entidad
        obj.setId_usuario_cliente(id);
        return repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
