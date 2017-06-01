/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.catalogoPelicula;

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
@Table(name = "catalogo_pelicula")
@ApiModel("Model Catalogo")
public class CatalogoPelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "id_catalogo", required = true)
    private Long idCatalogo;
    @ApiModelProperty(value = "id_pelicula", required = true)
    private Long idPelicula;

    public CatalogoPelicula() {
    }

    public CatalogoPelicula(Long id, Long idCatalogo, Long idPelicula) {
        this.id = id;
        this.idCatalogo = idCatalogo;
        this.idPelicula = idPelicula;
    }

    public Long id() {
        return id;
    }

    public Long idCatalogo() {
        return idCatalogo;
    }

    public Long idPelicula() {
        return idPelicula;
    }

}
