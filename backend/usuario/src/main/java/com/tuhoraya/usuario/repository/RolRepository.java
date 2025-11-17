package com.tuhoraya.usuario.repository;


import com.tuhoraya.usuario.model.Rol;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class RolRepository {
    private final Map<String, Rol> store = new HashMap<>();

    public List<Rol> findAll() {
        return new ArrayList<>(store.values());
    }

    public Rol findById(String id) {
        return store.get(id);
    }

    public void save(String id, Rol obj) {
        store.put(id, obj);
    }

    public void delete(String id) {
        store.remove(id);
    }
}