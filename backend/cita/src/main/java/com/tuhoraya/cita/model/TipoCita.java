package com.tuhoraya.cita.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_cita")
public class TipoCita {

    @Id
    @Column(name = "id_tipo_cita", length = 50)
    private String id_tipo_cita;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    public String getId_tipo_cita() { return id_tipo_cita; }
    public void setId_tipo_cita(String id_tipo_cita) { this.id_tipo_cita = id_tipo_cita; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
