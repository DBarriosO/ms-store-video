/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.catalogoPelicula.dto;

/**
 *
 * @author DESARROLLO
 */
public class CatalogoPeliculaDTO {

    private Long id;
    private Long idCatalogo;
    private Long idPelicula;

    public CatalogoPeliculaDTO() {
    }

    public CatalogoPeliculaDTO(Long id, Long idCatalogo, Long idPelicula) {
        this.id = id;
        this.idCatalogo = idCatalogo;
        this.idPelicula = idPelicula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Long idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

}
