package com.tuhoraya.profesion.model;

import jakarta.persistence.*;
@Entity
@Table(name = "servicio_profesional")
public class ServicioProfesional {
    @Id
    @Column(name = "id_servicio_profesional", length = 50)
    private String id_servicio_profesional;
    @Column(name = "descripcion_servicio_profesional", length = 100)
    private String descripcion_servicio_profesional;

    public String getId_servicio_profesional() { return id_servicio_profesional; }
    public void setId_servicio_profesional(String id_servicio_profesional) { this.id_servicio_profesional = id_servicio_profesional; }
    public String getDescripcion_servicio_profesional() { return descripcion_servicio_profesional; }
    public void setDescripcion_servicio_profesional(String descripcion_servicio_profesional) { this.descripcion_servicio_profesional = descripcion_servicio_profesional; }
}