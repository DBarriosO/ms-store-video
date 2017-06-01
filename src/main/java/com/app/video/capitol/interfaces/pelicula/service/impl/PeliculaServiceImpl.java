/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.pelicula.service.impl;

import com.app.video.capitol.dominio.pelicula.Pelicula;
import com.app.video.capitol.dominio.pelicula.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.app.video.capitol.interfaces.pelicula.service.PeliculaService;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
@Component("PeliculaService")
@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> findByEstado(String estado) {
        return peliculaRepository.findByEstado(estado);
    }

    @Override
    public Pelicula findById(Long id) {
        return peliculaRepository.findOne(id);
    }

    @Override
    public List<Pelicula> findAll() {
        return (List<Pelicula>) peliculaRepository.findAll();
    }

    @Override
    public Pelicula save(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }
}
