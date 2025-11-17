package com.tuhoraya.usuario.repository;

import com.tuhoraya.usuario.model.UsuarioCliente;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UsuarioClienteRepository {
    private final Map<String, UsuarioCliente> store = new HashMap<>();

    public List<UsuarioCliente> findAll() {
        return new ArrayList<>(store.values());
    }

    public UsuarioCliente findById(String id) {
        return store.get(id);
    }

    public void save(String id, UsuarioCliente obj) {
        store.put(id, obj);
    }

    public void delete(String id) {
        store.remove(id);
    }
}