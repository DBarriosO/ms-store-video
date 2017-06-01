/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.peliculaActor;

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
@Table(name = "pelicula_actor")
@ApiModel("Model PeliculaActor")
public class PeliculaActor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "id_actor", required = true)
    private Long idActor;
    @ApiModelProperty(value = "id_pelicula", required = true)
    private Long idPelicula;

    public PeliculaActor() {
    }

    public PeliculaActor(Long id, Long idActor, Long idPelicula) {
        this.id = id;
        this.idActor = idActor;
        this.idPelicula = idPelicula;
    }

    public Long id() {
        return id;
    }

    public Long idActor() {
        return idActor;
    }

    public Long idPelicula() {
        return idPelicula;
    }
}
