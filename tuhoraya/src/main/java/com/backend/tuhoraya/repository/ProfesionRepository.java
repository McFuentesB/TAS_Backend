package com.backend.tuhoraya.repository;

import com.backend.tuhoraya.model.Profesion;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ProfesionRepository {
    private final Map<String, Profesion> store = new HashMap<>();

    public List<Profesion> findAll() {
        return new ArrayList<>(store.values());
    }

    public Profesion findById(String id) {
        return store.get(id);
    }

    public void save(String id, Profesion obj) {
        store.put(id, obj);
    }

    public void delete(String id) {
        store.remove(id);
    }
}