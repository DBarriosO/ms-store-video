/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.catalogoPelicula.facade.impl;

import com.app.video.capitol.dominio.actor.Actor;
import com.app.video.capitol.dominio.catalogoPelicula.CatalogoPelicula;
import com.app.video.capitol.dominio.peliculaActor.PeliculaActor;
import com.app.video.capitol.interfaces.actor.service.ActorService;
import com.app.video.capitol.interfaces.catalogo.service.CatalogoService;
import com.app.video.capitol.interfaces.catalogoPelicula.dto.CatalogoPeliculaInfoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.app.video.capitol.interfaces.catalogoPelicula.facade.CatalogoPeliculaFacade;
import com.app.video.capitol.interfaces.catalogoPelicula.service.CatalogoPeliculaService;
import com.app.video.capitol.interfaces.pelicula.service.PeliculaService;
import com.app.video.capitol.interfaces.peliculaActor.service.PeliculaActorService;
import com.app.video.capitol.utils.ObjectMapperUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
@Component("CatalogoPeliculaFacade")
@Transactional
public class CatalogoPeliculaFacadeImpl implements CatalogoPeliculaFacade {

    @Autowired
    CatalogoPeliculaService catalogoPeliculaService;

    @Autowired
    CatalogoService catalogoService;

    @Autowired
    PeliculaService peliculaService;

    @Autowired
    ActorService actorService;

    @Autowired
    PeliculaActorService peliculaActorService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public List<CatalogoPeliculaInfoDTO> findByIdCatalogo(Long idCatalogo) {
        return convert(catalogoPeliculaService.findByIdCatalogo(idCatalogo));
    }

    @Override
    public List<CatalogoPeliculaInfoDTO> findByIdPelicula(Long idPelicula) {
        return convert(catalogoPeliculaService.findByIdPelicula(idPelicula));
    }

    @Override
    public CatalogoPeliculaInfoDTO findById(Long id) {
        return convert(catalogoPeliculaService.findById(id));
    }

    public List<CatalogoPeliculaInfoDTO> convert(List<CatalogoPelicula> catalogosPeliculas) {
        List<CatalogoPeliculaInfoDTO> catalogoDTOs = new ArrayList<>();
        catalogosPeliculas.stream().map((catalogoPelicula) -> {
            CatalogoPeliculaInfoDTO catalogoPeliculaInfoDTO = new CatalogoPeliculaInfoDTO();
            catalogoPeliculaInfoDTO.setId(catalogoPelicula.id());
            catalogoPeliculaInfoDTO.setIdCatalogo(catalogoPelicula.idCatalogo());
            catalogoPeliculaInfoDTO.setIdPelicula(catalogoPelicula.idPelicula());
            catalogoPeliculaInfoDTO.setCantidad(peliculaService.findById(catalogoPelicula.idPelicula()).cantidad());
            catalogoPeliculaInfoDTO.setDescripcion(peliculaService.findById(catalogoPelicula.idPelicula()).descripcion());
            catalogoPeliculaInfoDTO.setEstado(peliculaService.findById(catalogoPelicula.idPelicula()).estado());
            catalogoPeliculaInfoDTO.setNombreDirector(peliculaService.findById(catalogoPelicula.idPelicula()).nombreDirector());
            catalogoPeliculaInfoDTO.setTitulo(peliculaService.findById(catalogoPelicula.idPelicula()).titulo());
            catalogoPeliculaInfoDTO.setEstadoCatalogo(catalogoService.findById(catalogoPelicula.idCatalogo()).estado());
            catalogoPeliculaInfoDTO.setNombre(catalogoService.findById(catalogoPelicula.idCatalogo()).nombre());
            List<PeliculaActor> actors = peliculaActorService.findByIdPelicula(catalogoPelicula.idPelicula());
            StringBuilder actores = new StringBuilder();
            for (PeliculaActor peliculaActor : actors) {
                Actor actor = actorService.findById(peliculaActor.idActor());
                actores.append(actor.nombre()).append(",");
            }
            actores = actores.toString().isEmpty() ? actores : actores.deleteCharAt(actores.length() - 1);
            catalogoPeliculaInfoDTO.setActores(actores.toString());
            return catalogoPeliculaInfoDTO;
        }).forEachOrdered((catalogoPeliculaInfoDTO) -> {
            catalogoDTOs.add(catalogoPeliculaInfoDTO);
        });
        return catalogoDTOs;
    }

    public CatalogoPeliculaInfoDTO convert(CatalogoPelicula catalogoPelicula) {
        CatalogoPeliculaInfoDTO catalogoPeliculaInfoDTO = new CatalogoPeliculaInfoDTO();
        catalogoPeliculaInfoDTO.setId(catalogoPelicula.id());
        catalogoPeliculaInfoDTO.setIdCatalogo(catalogoPelicula.idCatalogo());
        catalogoPeliculaInfoDTO.setIdPelicula(catalogoPelicula.idPelicula());
        catalogoPeliculaInfoDTO.setCantidad(peliculaService.findById(catalogoPelicula.idPelicula()).cantidad());
        catalogoPeliculaInfoDTO.setDescripcion(peliculaService.findById(catalogoPelicula.idPelicula()).descripcion());
        catalogoPeliculaInfoDTO.setEstado(peliculaService.findById(catalogoPelicula.idPelicula()).estado());
        catalogoPeliculaInfoDTO.setNombreDirector(peliculaService.findById(catalogoPelicula.idPelicula()).nombreDirector());
        catalogoPeliculaInfoDTO.setTitulo(peliculaService.findById(catalogoPelicula.idPelicula()).titulo());
        catalogoPeliculaInfoDTO.setEstadoCatalogo(catalogoService.findById(catalogoPelicula.idCatalogo()).estado());
        catalogoPeliculaInfoDTO.setNombre(catalogoService.findById(catalogoPelicula.idCatalogo()).nombre());
        List<PeliculaActor> actors = peliculaActorService.findByIdPelicula(catalogoPelicula.idPelicula());
        StringBuilder actores = new StringBuilder();
        for (PeliculaActor peliculaActor : actors) {
            Actor actor = actorService.findById(peliculaActor.idActor());
            actores.append(actor.nombre()).append(",");
        }
        actores = actores.toString().isEmpty() ? actores : actores.deleteCharAt(actores.length() - 1);
        catalogoPeliculaInfoDTO.setActores(actores.toString());
        return catalogoPeliculaInfoDTO;
    }

}
