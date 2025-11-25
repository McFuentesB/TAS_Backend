package com.tuhoraya.profesion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rubro")
public class Rubro {
    @Id
    @Column(name = "id_rubro", length = 50)
    private String id_rubro;
    @Column(name = "descripcion", length = 100)
    private String descripcion;

    public String getId_rubro() { return id_rubro; }
    public void setId_rubro(String id_rubro) { this.id_rubro = id_rubro; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
