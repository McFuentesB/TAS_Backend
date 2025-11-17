package com.tuhoraya.cita.repository;


import com.tuhoraya.cita.model.Historial;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class HistorialRepository {
    private final Map<String, Historial> store = new HashMap<>();

    public List<Historial> findAll() {
        return new ArrayList<>(store.values());
    }

    public Historial findById(String id) {
        return store.get(id);
    }

    public void save(String id, Historial obj) {
        store.put(id, obj);
    }

    public void delete(String id) {
        store.remove(id);
    }
}