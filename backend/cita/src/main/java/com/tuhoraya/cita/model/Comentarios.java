package com.tuhoraya.cita.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comentarios")
public class Comentarios {

    @Id
    @Column(name = "id_comentario", length = 50)
    private String id_comentario;

    @Column(name = "id_usuario_profesional", length = 50)
    private String id_usuario_profesional;

    @Column(name = "id_usuario_cliente", length = 50)
    private String id_usuario_cliente;

    @Column(name = "calificacion", length = 10)
    private String calificacion;

    @Column(name = "comentario", length = 255)
    private String comentario;

    public String getId_comentario() { return id_comentario; }
    public void setId_comentario(String id_comentario) { this.id_comentario = id_comentario; }

    public String getId_usuario_profesional() { return id_usuario_profesional; }
    public void setId_usuario_profesional(String id_usuario_profesional) { this.id_usuario_profesional = id_usuario_profesional; }

    public String getId_usuario_cliente() { return id_usuario_cliente; }
    public void setId_usuario_cliente(String id_usuario_cliente) { this.id_usuario_cliente = id_usuario_cliente; }

    public String getCalificacion() { return calificacion; }
    public void setCalificacion(String calificacion) { this.calificacion = calificacion; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
}
