package com.tuhoraya.usuario.repository;

import com.tuhoraya.usuario.model.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, String> {
    @Query("SELECT uc FROM UsuarioCliente uc WHERE uc.id_usuario = :idUsuario")
    Optional<UsuarioCliente> findByIdUsuario(@Param("idUsuario") String idUsuario);
}
