package com.backend.tuhoraya.repository;

import com.backend.tuhoraya.model.TipoCita;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class TipoCitaRepository {
    private final Map<String, TipoCita> store = new HashMap<>();

    public List<TipoCita> findAll() {
        return new ArrayList<>(store.values());
    }

    public TipoCita findById(String id) {
        return store.get(id);
    }

    public void save(String id, TipoCita obj) {
        store.put(id, obj);
    }

    public void delete(String id) {
        store.remove(id);
    }
}