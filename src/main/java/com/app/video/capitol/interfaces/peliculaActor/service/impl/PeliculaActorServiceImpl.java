/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.peliculaActor.service.impl;

import com.app.video.capitol.dominio.peliculaActor.PeliculaActor;
import com.app.video.capitol.dominio.peliculaActor.PeliculaActorRepository;
import com.app.video.capitol.interfaces.peliculaActor.service.PeliculaActorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("PeliculaActorService")
@Service
public class PeliculaActorServiceImpl implements PeliculaActorService {

    @Autowired
    PeliculaActorRepository peliculaActorRepository;

    @Override
    public List<PeliculaActor> findByIdActor(Long idActor) {
        return peliculaActorRepository.findByIdActor(idActor);
    }

    @Override
    public List<PeliculaActor> findByIdPelicula(Long idPelicula) {
        return peliculaActorRepository.findByIdPelicula(idPelicula);
    }

    @Override
    public PeliculaActor findById(Long id) {
        return peliculaActorRepository.findOne(id);
    }

}
