/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.pelicula.facade;

import com.app.video.capitol.interfaces.pelicula.dto.PeliculaDTO;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface PeliculaFacade {

    List<PeliculaDTO> findByEstado(String estado);

    PeliculaDTO findById(Long id);
    
    List<PeliculaDTO> findAll();
}
