/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.peliculaActor;

import com.app.video.capitol.dominio.catalogoPelicula.*;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface PeliculaActorRepository extends CrudRepository<PeliculaActor, Long> {

    /**
     *
     * @param idPelicula
     * @return
     */
    List<PeliculaActor> findByIdPelicula(Long idPelicula);

    /**
     *
     * @param idActor
     * @return
     */
    List<PeliculaActor> findByIdActor(Long idActor);
}
