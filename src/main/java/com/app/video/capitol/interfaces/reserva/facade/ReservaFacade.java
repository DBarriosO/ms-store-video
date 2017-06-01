/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.reserva.facade;

import com.app.video.capitol.interfaces.reserva.dto.ReservaInDTO;
import com.app.video.capitol.interfaces.reserva.dto.ReservaOutDTO;
import com.app.video.capitol.utils.ResponseUtil;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface ReservaFacade {

    ResponseUtil save(ReservaInDTO reservaInDTO);

    ReservaOutDTO findById(Long id);

    List<ReservaOutDTO> findByIdCliente(Long idCliente, String estado);

    List<ReservaOutDTO> findByIdPelicula(Long idPelicula, String estado);

    ReservaOutDTO findByIdPeliculaAndIdClienteAndEstado(Long idPelicula, Long idCliente, String estado);

    List<ReservaOutDTO> findByEstado(String estado);

    List<ReservaOutDTO> findAll();
}
