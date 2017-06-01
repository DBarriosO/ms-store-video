/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.pelicula;

import com.app.video.capitol.dominio.reserva.Reserva;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface PeliculaRepository extends CrudRepository<Pelicula, Long> {

    /**
     *
     * @param titulo
     * @return
     */
    List<Pelicula> findByTitulo(String titulo);

    /**
     *
     * @param estado
     * @return
     */
    List<Pelicula> findByEstado(String estado);

    /**
     *
     * @param nombreDirector
     * @return
     */
    List<Pelicula> findByNombreDirector(String nombreDirector);

}
