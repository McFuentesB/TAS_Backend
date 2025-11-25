package com.tuhoraya.usuario.model;
import jakarta.persistence.*;
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @Column(name = "id_rol")
    private String id_rol;
    @Column(name = "descripcion")    
    private String descripcion;

    public String getId_rol() { return id_rol; }
    public void setId_rol(String id_rol) { this.id_rol = id_rol; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
