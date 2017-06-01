/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.pelicula.service;

import com.app.video.capitol.dominio.pelicula.Pelicula;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface PeliculaService {

    List<Pelicula> findByEstado(String estado);

    Pelicula findById(Long id);

    List<Pelicula> findAll();

    Pelicula save(Pelicula pelicula);

}
