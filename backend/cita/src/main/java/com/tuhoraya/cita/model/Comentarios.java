package com.tuhoraya.cita.model;


public class Comentarios {
    private String id_comentario;
    private String id_usuario_profesional;
    private String id_usuario_cliente;
    private String calificacion;
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
