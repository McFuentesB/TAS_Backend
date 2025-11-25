package com.tuhoraya.profesion.repository;


import com.tuhoraya.profesion.model.ServicioProfesional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioProfesionalRepository extends JpaRepository<ServicioProfesional, String> {
    // No necesitas agregar nada por ahora.
    // JpaRepository ya te da: findAll, findById, save, deleteById, etc.
}