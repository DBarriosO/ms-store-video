/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.cliente;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "cliente", uniqueConstraints
        = @UniqueConstraint(columnNames = "rut", name = "uk_rut")
)
@ApiModel("Model Cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "nombre", required = true)
    private String nombre;
    @ApiModelProperty(value = "rut", required = true)
    private String rut;
    @ApiModelProperty(value = "direccion", required = true)
    private String direccion;
    @ApiModelProperty(value = "telefono", required = true)
    private String telefono;
    @Column(unique = true)
    @ApiModelProperty(value = "email", required = true)
    private String email;
    @ApiModelProperty(value = "contrasenhia", required = true)
    private String contrasenhia;
    @ApiModelProperty(value = "estado", required = true)
    private String estado;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String rut, String direccion, String telefono, String email, String contrasenhia, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contrasenhia = contrasenhia;
        this.estado = estado;
    }

    public Long id() {
        return id;
    }

    public String nombre() {
        return nombre;
    }

    public String rut() {
        return rut;
    }

    public String direccion() {
        return direccion;
    }

    public String telefono() {
        return telefono;
    }

    public String email() {
        return email;
    }

    public String contrasenhia() {
        return contrasenhia;
    }

    public String estado() {
        return estado;
    }

}
