/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.pelicula.facade.impl;

import com.app.video.capitol.dominio.actor.Actor;
import com.app.video.capitol.dominio.catalogo.Catalogo;
import com.app.video.capitol.dominio.catalogoPelicula.CatalogoPelicula;
import com.app.video.capitol.dominio.pelicula.Pelicula;
import com.app.video.capitol.dominio.peliculaActor.PeliculaActor;
import com.app.video.capitol.interfaces.actor.service.ActorService;
import com.app.video.capitol.interfaces.catalogo.service.CatalogoService;
import com.app.video.capitol.interfaces.catalogoPelicula.service.CatalogoPeliculaService;
import com.app.video.capitol.interfaces.pelicula.dto.PeliculaDTO;
import com.app.video.capitol.interfaces.pelicula.facade.PeliculaFacade;
import com.app.video.capitol.interfaces.pelicula.service.PeliculaService;
import com.app.video.capitol.interfaces.peliculaActor.service.PeliculaActorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.app.video.capitol.utils.ObjectMapperUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
@Component("PeliculaFacade")
@Transactional
public class PeliculaFacadeImpl implements PeliculaFacade {

    @Autowired
    PeliculaService peliculaService;

    @Autowired
    PeliculaActorService peliculaActorService;

    @Autowired
    ActorService actorService;

    @Autowired
    CatalogoPeliculaService catalogoPeliculaService;

    @Autowired
    CatalogoService catalogoService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public List<PeliculaDTO> findByEstado(String estado) {
        return convert(peliculaService.findByEstado(estado));
    }

    @Override
    public PeliculaDTO findById(Long id) {
        return objectMapper.convertValue(peliculaService.findById(id), PeliculaDTO.class);
    }

    @Override
    public List<PeliculaDTO> findAll() {
        return convert(peliculaService.findAll());
    }

    public List<PeliculaDTO> convert(List<Pelicula> peliculas) {
        List<PeliculaDTO> peliculaDTOs = new ArrayList<>();

        peliculas.stream().map((pelicula) -> {
            List<PeliculaActor> actors = peliculaActorService.findByIdPelicula(pelicula.id());
            StringBuilder actores = new StringBuilder();
            for (PeliculaActor peliculaActor : actors) {
                Actor actor = actorService.findById(peliculaActor.idActor());
                actores.append(actor.nombre()).append(",");
            }
            List<CatalogoPelicula> catalogs = catalogoPeliculaService.findByIdPelicula(pelicula.id());
            StringBuilder catalogos = new StringBuilder();
            for (CatalogoPelicula catalogoPelicula : catalogs) {
                Catalogo catalogo = catalogoService.findById(catalogoPelicula.idCatalogo());
                catalogos.append(catalogo.nombre()).append(",");
            }
            actores = actores.toString().isEmpty() ? actores : actores.deleteCharAt(actores.length() - 1);
            catalogos = catalogos.toString().isEmpty() ? catalogos : catalogos.deleteCharAt(catalogos.length() - 1);
            PeliculaDTO peliculaDTO = new PeliculaDTO(pelicula.id(), pelicula.titulo(), pelicula.descripcion(), pelicula.nombreDirector(), pelicula.cantidad(), pelicula.estado(), catalogos.toString(), actores.toString());
            return peliculaDTO;
        }).forEachOrdered((peliculaDTO) -> {
            peliculaDTOs.add(peliculaDTO);
        });
        return peliculaDTOs;
    }

}
