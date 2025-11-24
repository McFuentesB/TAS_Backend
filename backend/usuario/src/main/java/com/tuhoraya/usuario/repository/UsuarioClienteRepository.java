package com.tuhoraya.usuario.repository;

import com.tuhoraya.usuario.model.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, String> {
}
