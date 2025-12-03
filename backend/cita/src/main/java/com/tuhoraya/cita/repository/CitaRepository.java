package com.tuhoraya.cita.repository;

import com.tuhoraya.cita.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, String> {
    // Buscar citas por ID del profesional
    @Query("SELECT c FROM Cita c WHERE c.id_usuario_profesional = :idProfesional")
    List<Cita> findByProfesionalId(@Param("idProfesional") String idProfesional);

    // Buscar citas por ID del cliente
    @Query("SELECT c FROM Cita c WHERE c.id_usuario_cliente = :idCliente")
    List<Cita> findByClienteId(@Param("idCliente") String idCliente);

    // Buscar citas por profesional y fecha
    @Query("SELECT c FROM Cita c WHERE c.id_usuario_profesional = :idProfesional AND c.fecha = :fecha")
    List<Cita> findByProfesionalIdAndFecha(@Param("idProfesional") String idProfesional, @Param("fecha") String fecha);
}
