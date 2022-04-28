package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Object Relational Mapping - ORM -
 * Identify attributes of the table with the values inside Java
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
@Table(name = "usuario_rol")
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String rol;

    @ManyToOne(
            targetEntity = UsuarioModel.class,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "id_usu")
    @JsonBackReference
    private UsuarioModel usuarioModel;

    // Constructors
    public UsuarioRol() {
    }

    public UsuarioRol(String rol, UsuarioModel usuarioModel) {
        this.rol = rol;
        this.usuarioModel = usuarioModel;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
