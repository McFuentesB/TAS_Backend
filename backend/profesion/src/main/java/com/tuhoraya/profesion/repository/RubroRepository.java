package com.tuhoraya.profesion.repository;


import com.tuhoraya.profesion.model.Rubro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepository extends JpaRepository<Rubro, String> {
    // No necesitas agregar nada por ahora.
    // JpaRepository ya te da: findAll, findById, save, deleteById, etc.
}