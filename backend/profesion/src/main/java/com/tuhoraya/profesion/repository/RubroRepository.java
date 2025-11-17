package com.tuhoraya.profesion.repository;


import com.tuhoraya.profesion.model.Rubro;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class RubroRepository {
    private final Map<String, Rubro> store = new HashMap<>();

    public List<Rubro> findAll() {
        return new ArrayList<>(store.values());
    }

    public Rubro findById(String id) {
        return store.get(id);
    }

    public void save(String id, Rubro obj) {
        store.put(id, obj);
    }

    public void delete(String id) {
        store.remove(id);
    }
}