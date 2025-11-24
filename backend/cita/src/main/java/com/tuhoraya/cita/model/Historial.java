package com.tuhoraya.cita.model;

import jakarta.persistence.*;

@Entity
@Table(name = "historial")
public class Historial {

    @Id
    @Column(name = "id_historial", length = 50)
    private String id_historial;

    @Column(name = "comentario", length = 255)
    private String comentario;

    @Column(name = "id_cita", length = 50)
    private String id_cita;

    public String getId_historial() { return id_historial; }
    public void setId_historial(String id_historial) { this.id_historial = id_historial; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public String getId_cita() { return id_cita; }
    public void setId_cita(String id_cita) { this.id_cita = id_cita; }
}
