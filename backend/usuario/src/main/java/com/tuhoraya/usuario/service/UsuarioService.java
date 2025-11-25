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
        }

        repository.save(usuario);

        if (userType != null && !userType.isEmpty()) {
            if (userType.equals("cliente")) {
                UsuarioCliente cliente = new UsuarioCliente();
                cliente.setId_usuario_cliente(UUID.randomUUID().toString());
                cliente.setId_usuario(usuario.getId_usuario());
                clienteRepository.save(cliente);
            } else if (userType.equals("profesional")) {
                UsuarioProfesional profesional = new UsuarioProfesional();
                profesional.setId_usuario_profesional(UUID.randomUUID().toString());
                profesional.setId_usuario(usuario.getId_usuario());
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
