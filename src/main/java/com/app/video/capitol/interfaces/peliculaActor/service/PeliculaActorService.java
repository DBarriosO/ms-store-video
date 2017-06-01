/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.peliculaActor.service;

import com.app.video.capitol.dominio.peliculaActor.PeliculaActor;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface PeliculaActorService {

    List<PeliculaActor> findByIdActor(Long idActor);

    List<PeliculaActor> findByIdPelicula(Long idPelicula);

    PeliculaActor findById(Long id);
}
