package com.tuhoraya.cita.repository;


import com.tuhoraya.cita.model.Comentarios;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ComentariosRepository {
    private final Map<String, Comentarios> store = new HashMap<>();

    public List<Comentarios> findAll() {
        return new ArrayList<>(store.values());
    }

    public Comentarios findById(String id) {
        return store.get(id);
    }

    public void save(String id, Comentarios obj) {
        store.put(id, obj);
    }

    public void delete(String id) {
        store.remove(id);
    }
}