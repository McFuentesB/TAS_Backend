package com.tuhoraya.usuario.repository;

import com.tuhoraya.usuario.model.UsuarioProfesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioProfesionalRepository extends JpaRepository<UsuarioProfesional, String> {
    @Query("SELECT up FROM UsuarioProfesional up WHERE up.id_usuario = :idUsuario")
    Optional<UsuarioProfesional> findByIdUsuario(@Param("idUsuario") String idUsuario);
}
