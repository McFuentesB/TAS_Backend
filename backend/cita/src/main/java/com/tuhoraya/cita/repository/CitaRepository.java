package com.tuhoraya.cita.repository;

import com.tuhoraya.cita.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, String> {
    // No necesitas agregar nada por ahora.
    // JpaRepository ya te da: findAll, findById, save, deleteById, etc.
}
