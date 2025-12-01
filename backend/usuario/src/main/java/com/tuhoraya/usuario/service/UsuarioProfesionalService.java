package com.tuhoraya.usuario.service;

import com.tuhoraya.usuario.dto.UsuarioProfesionalDTO;
import com.tuhoraya.usuario.model.Usuario;
import com.tuhoraya.usuario.model.UsuarioProfesional;
import com.tuhoraya.usuario.repository.UsuarioProfesionalRepository;
import com.tuhoraya.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UsuarioProfesionalService {
    private final UsuarioProfesionalRepository repository;
    private final UsuarioRepository usuarioRepository;

    public UsuarioProfesionalService(UsuarioProfesionalRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioProfesional> getAll() {
        return repository.findAll();
    }

    public List<UsuarioProfesionalDTO> getAllWithUserData() {
        List<UsuarioProfesional> profesionales = repository.findAll();

        return profesionales.stream()
            .map(prof -> {
                Usuario usuario = usuarioRepository.findById(prof.getId_usuario()).orElse(null);
                if (usuario != null) {
                    return buildDTO(prof, usuario);
                }
                return null;
            })
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    private UsuarioProfesionalDTO buildDTO(UsuarioProfesional prof, Usuario usuario) {
        UsuarioProfesionalDTO dto = new UsuarioProfesionalDTO();
        dto.setId_usuario_profesional(prof.getId_usuario_profesional());
        dto.setId_usuario(prof.getId_usuario());
        dto.setId_profesion(prof.getId_profesion());
        dto.setId_servicio_profesional(prof.getId_servicio_profesional());
        dto.setId_rubro(prof.getId_rubro());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setCorreo(usuario.getCorreo());
        dto.setFoto_url(usuario.getFoto_url());
        dto.setDescripcion(prof.getDescripcion());
        dto.setExperiencia(prof.getExperiencia());
        dto.setPais(prof.getPais());
        dto.setCiudad(prof.getCiudad());
        dto.setServicios(prof.getServicios());
        dto.setPrecioHora(prof.getPrecioHora());
        return dto;
    }

    public UsuarioProfesional getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public UsuarioProfesionalDTO getByIdWithUserData(String id) {
        UsuarioProfesional prof = repository.findById(id).orElse(null);
        if (prof != null) {
            Usuario usuario = usuarioRepository.findById(prof.getId_usuario()).orElse(null);
            if (usuario != null) {
                return buildDTO(prof, usuario);
            }
        }
        return null;
    }

    public UsuarioProfesional save(String id, UsuarioProfesional obj) {
        obj.setId_usuario_profesional(id);
        return repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
