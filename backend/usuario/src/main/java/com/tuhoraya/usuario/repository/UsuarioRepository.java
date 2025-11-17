package com.tuhoraya.usuario.repository;


import com.tuhoraya.usuario.model.Usuario;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UsuarioRepository {
    private final Map<String, Usuario> store = new HashMap<>();

    public List<Usuario> findAll() {
        return new ArrayList<>(store.values());
    }

    public Usuario findById(String id) {
        return store.get(id);
    }

    public void save(String id, Usuario obj) {
        store.put(id, obj);
    }

    public void delete(String id) {
        store.remove(id);
    }
}
