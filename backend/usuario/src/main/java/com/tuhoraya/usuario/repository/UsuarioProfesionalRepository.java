package com.tuhoraya.usuario.repository;

import com.tuhoraya.usuario.model.UsuarioProfesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioProfesionalRepository extends JpaRepository<UsuarioProfesional, String> {
}
