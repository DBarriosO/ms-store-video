/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.catalogoPelicula.service;

import com.app.video.capitol.dominio.catalogoPelicula.CatalogoPelicula;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface CatalogoPeliculaService {

    List<CatalogoPelicula> findByIdCatalogo(Long idCatalogo);

    List<CatalogoPelicula> findByIdPelicula(Long idPelicula);

    CatalogoPelicula findById(Long id);

}
