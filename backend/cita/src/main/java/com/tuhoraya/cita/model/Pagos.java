package com.tuhoraya.cita.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pagos")
public class Pagos {

    @Id
    @Column(name = "id_pago", length = 50)
    private String id_pago;

    @Column(name = "estado_pago", length = 50)
    private String estado_pago;

    public String getId_pago() { return id_pago; }
    public void setId_pago(String id_pago) { this.id_pago = id_pago; }

    public String getEstado_pago() { return estado_pago; }
    public void setEstado_pago(String estado_pago) { this.estado_pago = estado_pago; }
}
