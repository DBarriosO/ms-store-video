/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.catalogo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
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
@Table(name = "catalogo", uniqueConstraints
        = @UniqueConstraint(columnNames = "nombre", name = "uk_nombre"))
@ApiModel("Model Catalogo")
public class Catalogo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "nombre", required = true)
    private String nombre;
    @ApiModelProperty(value = "estado", required = true)
    private String estado;

    public Catalogo() {
    }

    public Catalogo(Long id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long id() {
        return id;
    }

    public String nombre() {
        return nombre;
    }

    public String estado() {
        return estado;
    }

}
