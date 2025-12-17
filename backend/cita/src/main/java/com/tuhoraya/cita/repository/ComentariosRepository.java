package com.tuhoraya.cita.repository;

import com.tuhoraya.cita.model.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentariosRepository extends JpaRepository<Comentarios, String> {
    List<Comentarios> findByIdUsuarioProfesional(String idUsuarioProfesional);
    List<Comentarios> findByIdUsuarioProfesionalAndIdUsuarioCliente(String idUsuarioProfesional, String idUsuarioCliente);
}
