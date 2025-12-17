package com.tuhoraya.cita.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) // ✅ CLAVE
@Entity
@Table(name = "comentarios")
public class Comentarios {

    @Id
    @Column(name = "id_comentario", length = 50)
    private String idComentario;

    @Column(name = "id_usuario_profesional", length = 50)
    private String idUsuarioProfesional;

    @Column(name = "id_usuario_cliente", length = 50)
    private String idUsuarioCliente;

    @Column(name = "calificacion", length = 10)
    private String calificacion;

    @Column(name = "comentario", length = 255)
    private String comentario;

    public String getIdComentario() { return idComentario; }
    public void setIdComentario(String idComentario) { this.idComentario = idComentario; }

    public String getIdUsuarioProfesional() { return idUsuarioProfesional; }
    public void setIdUsuarioProfesional(String idUsuarioProfesional) { this.idUsuarioProfesional = idUsuarioProfesional; }

    public String getIdUsuarioCliente() { return idUsuarioCliente; }
    public void setIdUsuarioCliente(String idUsuarioCliente) { this.idUsuarioCliente = idUsuarioCliente; }

    public String getCalificacion() { return calificacion; }
    public void setCalificacion(String calificacion) { this.calificacion = calificacion; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
}
