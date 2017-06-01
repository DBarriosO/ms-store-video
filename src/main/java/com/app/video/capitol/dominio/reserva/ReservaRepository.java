/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.reserva;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface ReservaRepository extends CrudRepository<Reserva, Long> {

    /**
     *
     * @param estado
     * @return
     */
    List<Reserva> findByEstado(String estado);

    /**
     *
     * @param idPelicula
     * @return
     */
    List<Reserva> findByIdPelicula(Long idPelicula);

    /**
     *
     * @param idCliente
     * @return
     */
    List<Reserva> findByIdCliente(Long idCliente);

    /**
     *
     * @param idPelicula
     * @param idCliente
     * @param estado
     * @return
     */
    Reserva findByIdPeliculaAndIdClienteAndEstado(Long idPelicula, Long idCliente, String estado);

}
