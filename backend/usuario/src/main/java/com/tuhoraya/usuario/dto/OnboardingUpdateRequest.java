package com.tuhoraya.usuario.dto;

public class OnboardingUpdateRequest {
    private String nombre;
    private String apellido;
    private String telefono;
    private String foto_url;
    private String userType;

    public OnboardingUpdateRequest() {}

    public OnboardingUpdateRequest(String nombre, String apellido, String telefono, String foto_url, String userType) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.foto_url = foto_url;
        this.userType = userType;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getFoto_url() { return foto_url; }
    public void setFoto_url(String foto_url) { this.foto_url = foto_url; }

    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }
}
