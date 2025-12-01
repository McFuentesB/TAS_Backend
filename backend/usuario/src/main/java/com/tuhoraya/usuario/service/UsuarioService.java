package com.tuhoraya.usuario.service;

import com.tuhoraya.usuario.dto.LoginRequest;
import com.tuhoraya.usuario.dto.LoginResponse;
import com.tuhoraya.usuario.dto.AzureAdSyncRequest;
import com.tuhoraya.usuario.dto.OnboardingUpdateRequest;
import com.tuhoraya.usuario.model.Usuario;
import com.tuhoraya.usuario.model.UsuarioCliente;
import com.tuhoraya.usuario.model.UsuarioProfesional;
import com.tuhoraya.usuario.repository.UsuarioRepository;
import com.tuhoraya.usuario.repository.UsuarioClienteRepository;
import com.tuhoraya.usuario.repository.UsuarioProfesionalRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioClienteRepository clienteRepository;
    private final UsuarioProfesionalRepository profesionalRepository;

    public UsuarioService(
        UsuarioRepository repository,
        UsuarioClienteRepository clienteRepository,
        UsuarioProfesionalRepository profesionalRepository
    ) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.profesionalRepository = profesionalRepository;
    }

    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Usuario getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario save(String id, Usuario obj) {
        obj.setId_usuario(id);
        return repository.save(obj);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public LoginResponse login(LoginRequest request) {
        Usuario usuario = repository.findByCorreoAndClave(request.getCorreo(), request.getClave());

        if (usuario != null) {
            return new LoginResponse(
                true,
                "Login exitoso",
                usuario.getId_usuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCorreo(),
                usuario.getFoto_url(),
                usuario.getId_rol(),
                usuario.getOnboarded() != null ? usuario.getOnboarded() : true
            );
        }

        return new LoginResponse(false, "Credenciales inválidas");
    }

    public LoginResponse syncAzureAdUser(AzureAdSyncRequest request) {
        // Buscar usuario por correo
        Usuario usuario = repository.findByCorreo(request.getCorreo());

        if (usuario != null) {
            // Usuario existe - retornar sus datos completos y estado de onboarding
            return new LoginResponse(
                true,
                "Usuario sincronizado exitosamente",
                usuario.getId_usuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCorreo(),
                usuario.getFoto_url(),
                usuario.getId_rol(),
                usuario.getOnboarded() != null ? usuario.getOnboarded() : false
            );
        } else {
            // Usuario NO existe - crearlo con datos básicos de Azure AD
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setId_usuario(UUID.randomUUID().toString());
            nuevoUsuario.setCorreo(request.getCorreo());
            nuevoUsuario.setNombre(request.getNombre());
            nuevoUsuario.setOnboarded(false); // Marcar como no completado

            repository.save(nuevoUsuario);

            // Retornar datos del nuevo usuario indicando que necesita onboarding
            return new LoginResponse(
                true,
                "Usuario creado - requiere completar onboarding",
                nuevoUsuario.getId_usuario(),
                nuevoUsuario.getNombre(),
                null, // apellido
                nuevoUsuario.getCorreo(),
                null, // foto_url
                null, // id_rol
                false // onboarded = false
            );
        }
    }

    public LoginResponse completeOnboarding(String id, OnboardingUpdateRequest request) {
        System.out.println("=== ONBOARDING REQUEST ===");
        System.out.println("precioHora recibido: " + request.getPrecioHora());
        System.out.println("userType: " + request.getUserType());
        System.out.println("===========================");

        Usuario usuario = repository.findById(id).orElse(null);

        if (usuario == null) {
            return new LoginResponse(false, "Usuario no encontrado");
        }

        if (request.getNombre() != null && !request.getNombre().isEmpty()) {
            usuario.setNombre(request.getNombre());
        }
        if (request.getApellido() != null && !request.getApellido().isEmpty()) {
            usuario.setApellido(request.getApellido());
        }
        if (request.getTelefono() != null && !request.getTelefono().isEmpty()) {
            usuario.setTelefono(request.getTelefono());
        }
        if (request.getFoto_url() != null) {
            usuario.setFoto_url(request.getFoto_url().isEmpty() ? null : request.getFoto_url());
        }

        usuario.setOnboarded(true);

        String userType = request.getUserType();
        if (userType != null && !userType.isEmpty()) {
            usuario.setUserType(userType);
            
            // Asignar rol automáticamente basado en userType
            if (userType.equals("cliente")) {
                usuario.setId_rol("ROL_CLIENTE");
            } else if (userType.equals("profesional")) {
                usuario.setId_rol("ROL_PROFESIONAL");
            }
        }

        repository.save(usuario);

        if (userType != null && !userType.isEmpty()) {
            if (userType.equals("cliente")) {
                UsuarioCliente cliente = clienteRepository.findByIdUsuario(usuario.getId_usuario())
                    .orElseGet(() -> {
                        UsuarioCliente nuevo = new UsuarioCliente();
                        nuevo.setId_usuario_cliente(UUID.randomUUID().toString());
                        nuevo.setId_usuario(usuario.getId_usuario());
                        return nuevo;
                    });
                clienteRepository.save(cliente);
            } else if (userType.equals("profesional")) {
                UsuarioProfesional profesional = profesionalRepository.findByIdUsuario(usuario.getId_usuario())
                    .orElseGet(() -> {
                        UsuarioProfesional nuevo = new UsuarioProfesional();
                        nuevo.setId_usuario_profesional(UUID.randomUUID().toString());
                        nuevo.setId_usuario(usuario.getId_usuario());
                        return nuevo;
                    });

                if (request.getId_profesion() != null && !request.getId_profesion().isEmpty()) {
                    profesional.setId_profesion(request.getId_profesion());
                }
                if (request.getId_rubro() != null && !request.getId_rubro().isEmpty()) {
                    profesional.setId_rubro(request.getId_rubro());
                }
                if (request.getId_servicio_profesional() != null && !request.getId_servicio_profesional().isEmpty()) {
                    profesional.setId_servicio_profesional(request.getId_servicio_profesional());
                }
                if (request.getDescripcion() != null) {
                    profesional.setDescripcion(request.getDescripcion());
                }
                if (request.getExperiencia() != null) {
                    profesional.setExperiencia(request.getExperiencia());
                }
                if (request.getPais() != null) {
                    profesional.setPais(request.getPais());
                }
                if (request.getCiudad() != null) {
                    profesional.setCiudad(request.getCiudad());
                }
                if (request.getServicios() != null) {
                    profesional.setServicios(request.getServicios());
                }
                if (request.getPrecioHora() != null) {
                    profesional.setPrecioHora(request.getPrecioHora());
                }

                profesionalRepository.save(profesional);
            }
        }

        return new LoginResponse(
            true,
            "Onboarding completado exitosamente",
            usuario.getId_usuario(),
            usuario.getNombre(),
            usuario.getApellido(),
            usuario.getCorreo(),
            usuario.getFoto_url(),
            usuario.getId_rol(),
            true
        );
    }

}
