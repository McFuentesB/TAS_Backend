package com.tuhoraya.usuario.dto;

public class UsuarioProfesionalDTO {
    private String id_usuario_profesional;
    private String id_usuario;
    private String id_profesion;
    private String id_servicio_profesional;
    private String id_rubro;

    // Datos del usuario
    private String nombre;
    private String apellido;
    private String correo;
    private String foto_url;

    // Constructor vacío
    public UsuarioProfesionalDTO() {
    }

    // Constructor completo
    public UsuarioProfesionalDTO(String id_usuario_profesional, String id_usuario, String id_profesion,
                                  String id_servicio_profesional, String id_rubro, String nombre,
                                  String apellido, String correo, String foto_url) {
        this.id_usuario_profesional = id_usuario_profesional;
        this.id_usuario = id_usuario;
        this.id_profesion = id_profesion;
        this.id_servicio_profesional = id_servicio_profesional;
        this.id_rubro = id_rubro;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.foto_url = foto_url;
    }

    // Getters y Setters
    public String getId_usuario_profesional() { return id_usuario_profesional; }
    public void setId_usuario_profesional(String id_usuario_profesional) { this.id_usuario_profesional = id_usuario_profesional; }

    public String getId_usuario() { return id_usuario; }
    public void setId_usuario(String id_usuario) { this.id_usuario = id_usuario; }

    public String getId_profesion() { return id_profesion; }
    public void setId_profesion(String id_profesion) { this.id_profesion = id_profesion; }

    public String getId_servicio_profesional() { return id_servicio_profesional; }
    public void setId_servicio_profesional(String id_servicio_profesional) { this.id_servicio_profesional = id_servicio_profesional; }

    public String getId_rubro() { return id_rubro; }
    public void setId_rubro(String id_rubro) { this.id_rubro = id_rubro; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getFoto_url() { return foto_url; }
    public void setFoto_url(String foto_url) { this.foto_url = foto_url; }
}
