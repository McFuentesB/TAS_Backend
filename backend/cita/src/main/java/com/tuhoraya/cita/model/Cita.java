package com.tuhoraya.cita.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @Column(name = "id_cita", length = 50)
    private String id_cita;

    @Column(name = "id_usuario_cliente", length = 50)
    private String id_usuario_cliente;

    @Column(name = "id_usuario_profesional", length = 50)
    private String id_usuario_profesional;

    @Column(name = "fecha", length = 20)
    private String fecha;

    @Column(name = "hora", length = 20)
    private String hora;

    @Column(name = "comentario", length = 255)
    private String comentario;

    @Column(name = "calificacion", length = 10)
    private String calificacion;

    @Column(name = "id_tipo_cita", length = 50)
    private String id_tipo_cita;

    @Column(name = "id_pago", length = 50)
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
