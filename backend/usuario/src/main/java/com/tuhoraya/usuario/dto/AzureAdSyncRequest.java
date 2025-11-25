package com.tuhoraya.usuario.dto;

public class AzureAdSyncRequest {
    private String correo;
    private String nombre;
    private String accessToken;

    public AzureAdSyncRequest() {}

    public AzureAdSyncRequest(String correo, String nombre, String accessToken) {
        this.correo = correo;
        this.nombre = nombre;
        this.accessToken = accessToken;
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
}
