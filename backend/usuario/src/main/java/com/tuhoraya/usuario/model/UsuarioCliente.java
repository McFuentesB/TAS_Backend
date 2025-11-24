package com.tuhoraya.usuario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_cliente")
public class UsuarioCliente {
    @Id
    @Column(name = "id_usuario_cliente", length = 36)
    private String id_usuario_cliente;

    @Column(name = "id_usuario", length = 36)
    private String id_usuario;

    public String getId_usuario_cliente() { return id_usuario_cliente; }
    public void setId_usuario_cliente(String id_usuario_cliente) { this.id_usuario_cliente = id_usuario_cliente; }
    public String getId_usuario() { return id_usuario; }
    public void setId_usuario(String id_usuario) { this.id_usuario = id_usuario; }
}
