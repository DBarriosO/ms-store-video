/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.pelicula;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "pelicula")
@ApiModel("Model Pelicula")
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "titulo", required = true)
    private String titulo;
    @ApiModelProperty(value = "descripcion", required = true)
    private String descripcion;
    @ApiModelProperty(value = "nombre_director", required = true)
    private String nombreDirector;
    @ApiModelProperty(value = "cantidad", required = true)
    private Integer cantidad;
    @ApiModelProperty(value = "estado", required = true)
    private String estado;

    public Pelicula() {
    }

    public Pelicula(Long id, String titulo, String descripcion, String nombreDirector, Integer cantidad, String estado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombreDirector = nombreDirector;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public Long id() {
        return id;
    }

    public String titulo() {
        return titulo;
    }

    public String descripcion() {
        return descripcion;
    }

    public String nombreDirector() {
        return nombreDirector;
    }

    public Integer cantidad() {
        return cantidad;
    }

    public String estado() {
        return estado;
    }

}
