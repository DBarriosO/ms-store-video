/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.catalogoPelicula;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface CatalogoPeliculaRepository extends CrudRepository<CatalogoPelicula, Long> {

    /**
     *
     * @param idPelicula
     * @return
     */
    List<CatalogoPelicula> findByIdPelicula(Long idPelicula);

    /**
     *
     * @param idCatalogo
     * @return
     */
    List<CatalogoPelicula> findByIdCatalogo(Long idCatalogo);
}
