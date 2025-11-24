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
                    return new UsuarioProfesionalDTO(
                        prof.getId_usuario_profesional(),
                        prof.getId_usuario(),
                        prof.getId_profesion(),
                        prof.getId_servicio_profesional(),
                        prof.getId_rubro(),
                        usuario.getNombre(),
                        usuario.getApellido(),
                        usuario.getCorreo(),
                        usuario.getFoto_url()
                    );
                }
                return null;
            })
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    public UsuarioProfesional getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public UsuarioProfesionalDTO getByIdWithUserData(String id) {
        UsuarioProfesional prof = repository.findById(id).orElse(null);
        if (prof != null) {
            Usuario usuario = usuarioRepository.findById(prof.getId_usuario()).orElse(null);
            if (usuario != null) {
                return new UsuarioProfesionalDTO(
                    prof.getId_usuario_profesional(),
                    prof.getId_usuario(),
                    prof.getId_profesion(),
                    prof.getId_servicio_profesional(),
                    prof.getId_rubro(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getCorreo(),
                    usuario.getFoto_url()
                );
            }
        }
        return null;
    }

    public void save(String id, UsuarioProfesional obj) {
        obj.setId_usuario_profesional(id);
        repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
