/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.catalogoPelicula.facade;

import com.app.video.capitol.interfaces.catalogoPelicula.dto.CatalogoPeliculaInfoDTO;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface CatalogoPeliculaFacade {

    List<CatalogoPeliculaInfoDTO> findByIdCatalogo(Long idCatalogo);

    List<CatalogoPeliculaInfoDTO> findByIdPelicula(Long idPelicula);

    CatalogoPeliculaInfoDTO findById(Long id);
}
