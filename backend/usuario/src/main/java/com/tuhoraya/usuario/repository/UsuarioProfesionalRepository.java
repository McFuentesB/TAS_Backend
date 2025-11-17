package com.tuhoraya.usuario.repository;


import com.tuhoraya.usuario.model.UsuarioProfesional;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UsuarioProfesionalRepository {
    private final Map<String, UsuarioProfesional> store = new HashMap<>();

    public List<UsuarioProfesional> findAll() {
        return new ArrayList<>(store.values());
    }

    public UsuarioProfesional findById(String id) {
        return store.get(id);
    }

    public void save(String id, UsuarioProfesional obj) {
        store.put(id, obj);
    }

    public void delete(String id) {
        store.remove(id);
    }
}