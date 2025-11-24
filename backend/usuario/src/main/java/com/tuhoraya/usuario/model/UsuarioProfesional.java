package com.tuhoraya.usuario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_profesional")
public class UsuarioProfesional {
    @Id
    @Column(name = "id_usuario_profesional", length = 36)
    private String id_usuario_profesional;

    @Column(name = "id_usuario", length = 36)
    private String id_usuario;

    @Column(name = "id_profesion", length = 36)
    private String id_profesion;

    @Column(name = "id_servicio_profesional", length = 36)
    private String id_servicio_profesional;

    @Column(name = "id_rubro", length = 36)
    private String id_rubro;

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
}
