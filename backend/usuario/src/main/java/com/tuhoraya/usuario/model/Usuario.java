package com.tuhoraya.usuario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "id_usuario", length = 36)
    private String id_usuario;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "apellido", length = 100)
    private String apellido;

    @Column(name = "correo", length = 150, unique = true)
    private String correo;

    @Column(name = "clave", length = 255)
    private String clave;

    @Column(name = "id_rol", length = 36)
    private String id_rol;

    @Column(name = "foto_url", length = 500)
    private String foto_url;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "onboarded", nullable = false)
    private Boolean onboarded = false;

    @Column(name = "user_type", length = 20)
    private String userType;

    public String getId_usuario() { return id_usuario; }
    public void setId_usuario(String id_usuario) { this.id_usuario = id_usuario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }
    public String getId_rol() { return id_rol; }
    public void setId_rol(String id_rol) { this.id_rol = id_rol; }
    public String getFoto_url() { return foto_url; }
    public void setFoto_url(String foto_url) { this.foto_url = foto_url; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public Boolean getOnboarded() { return onboarded; }
    public void setOnboarded(Boolean onboarded) { this.onboarded = onboarded; }
    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }
}
