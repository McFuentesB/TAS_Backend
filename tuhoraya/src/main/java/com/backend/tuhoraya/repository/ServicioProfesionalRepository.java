package com.backend.tuhoraya.repository;

import com.backend.tuhoraya.model.ServicioProfesional;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ServicioProfesionalRepository {
    private final Map<String, ServicioProfesional> store = new HashMap<>();

    public List<ServicioProfesional> findAll() {
        return new ArrayList<>(store.values());
    }

    public ServicioProfesional findById(String id) {
        return store.get(id);
    }

    public void save(String id, ServicioProfesional obj) {
        store.put(id, obj);
    }

    public void delete(String id) {
        store.remove(id);
    }
}