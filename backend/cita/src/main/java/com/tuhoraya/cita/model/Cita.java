package com.tuhoraya.cita.model;


public class Cita {
    private String id_cita;
    private String id_usuario_cliente;
    private String id_usuario_profesional;
    private String fecha;
    private String hora;
    private String comentario;
    private String calificacion;
    private String id_tipo_cita;
    private String id_pago;

    public String getId_cita() { return id_cita; }
    public void setId_cita(String id_cita) { this.id_cita = id_cita; }

    public String getId_usuario_cliente() { return id_usuario_cliente; }
    public void setId_usuario_cliente(String id_usuario_cliente) { this.id_usuario_cliente = id_usuario_cliente; }

    public String getId_usuario_profesional() { return id_usuario_profesional; }
    public void setId_usuario_profesional(String id_usuario_profesional) { this.id_usuario_profesional = id_usuario_profesional; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public String getCalificacion() { return calificacion; }
    public void setCalificacion(String calificacion) { this.calificacion = calificacion; }

    public String getId_tipo_cita() { return id_tipo_cita; }
    public void setId_tipo_cita(String id_tipo_cita) { this.id_tipo_cita = id_tipo_cita; }

    public String getId_pago() { return id_pago; }
    public void setId_pago(String id_pago) { this.id_pago = id_pago; }
}
