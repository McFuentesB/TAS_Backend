package com.tuhoraya.cita.repository;


import com.tuhoraya.cita.model.Cita;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class CitaRepository {
    private final Map<String, Cita> store = new HashMap<>();

    public List<Cita> findAll() {
        return new ArrayList<>(store.values());
    }

    public Cita findById(String id) {
        return store.get(id);
    }

    public void save(String id, Cita obj) {
        store.put(id, obj);
    }

    public void delete(String id) {
        store.remove(id);
    }
}
