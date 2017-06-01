/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.catalogoPelicula.service.impl;

import com.app.video.capitol.dominio.catalogoPelicula.CatalogoPelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.app.video.capitol.dominio.catalogoPelicula.CatalogoPeliculaRepository;
import com.app.video.capitol.interfaces.catalogoPelicula.service.CatalogoPeliculaService;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
@Component("CatalogoPeliculaService")
@Service
public class CatalogoPeliculaServiceImpl implements CatalogoPeliculaService {

    @Autowired
    CatalogoPeliculaRepository catalogoPeliculaRepository;

    @Override
    public List<CatalogoPelicula> findByIdCatalogo(Long idCatalogo) {
      return catalogoPeliculaRepository.findByIdCatalogo(idCatalogo);
    }

    @Override
    public List<CatalogoPelicula> findByIdPelicula(Long idPelicula) {
        return catalogoPeliculaRepository.findByIdPelicula(idPelicula);
    }

    @Override
    public CatalogoPelicula findById(Long id) {
        return catalogoPeliculaRepository.findOne(id);
    }

}
