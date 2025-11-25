package com.tuhoraya.profesion.model;
import jakarta.persistence.*;
@Entity
@Table(name = "profesion")
public class Profesion {
    @Id
    @Column(name = "id_profesion", length = 50)
    private String id_profesion;
    @Column(name = "descripcion", length = 100)
    private String descripcion;

    public String getId_profesion() { return id_profesion; }
    public void setId_profesion(String id_profesion) { this.id_profesion = id_profesion; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
