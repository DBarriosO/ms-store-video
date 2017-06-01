/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.reserva.service;

import com.app.video.capitol.dominio.reserva.Reserva;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface ReservaService {

    Reserva save(Reserva reserva);

    Reserva findById(Long id);

    List<Reserva> findByIdCliente(Long idCliente, String estado);

    List<Reserva> findByIdPelicula(Long idPelicula, String estado);

    Reserva findByIdPeliculaAndIdClienteAndEstado(Long idPelicula, Long idCliente, String estado);

    List<Reserva> findByEstado(String estado);

    List<Reserva> findAll();
}
