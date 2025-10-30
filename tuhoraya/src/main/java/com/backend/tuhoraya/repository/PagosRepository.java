package com.backend.tuhoraya.repository;

import com.backend.tuhoraya.model.Pagos;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class PagosRepository {
    private final Map<String, Pagos> store = new HashMap<>();

    public List<Pagos> findAll() {
        return new ArrayList<>(store.values());
    }

    public Pagos findById(String id) {
        return store.get(id);
    }

    public void save(String id, Pagos obj) {
        store.put(id, obj);
    }

    public void delete(String id) {
        store.remove(id);
    }
}