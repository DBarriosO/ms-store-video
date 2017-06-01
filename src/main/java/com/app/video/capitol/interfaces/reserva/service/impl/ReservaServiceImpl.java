/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.reserva.service.impl;

import com.app.video.capitol.dominio.reserva.Reserva;
import com.app.video.capitol.dominio.reserva.ReservaRepository;
import com.app.video.capitol.interfaces.reserva.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("ReservaService")
@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    @Override
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva findById(Long id) {
        return reservaRepository.findOne(id);
    }

    @Override
    public List<Reserva> findByIdCliente(Long idCliente, String estado) {
        return reservaRepository.findByIdCliente(idCliente);
    }

    @Override
    public List<Reserva> findByIdPelicula(Long idPelicula, String estado) {
        return reservaRepository.findByIdPelicula(idPelicula);
    }

    @Override
    public Reserva findByIdPeliculaAndIdClienteAndEstado(Long idPelicula, Long idCliente, String estado) {
        return reservaRepository.findByIdPeliculaAndIdClienteAndEstado(idPelicula, idCliente, estado);
    }

    @Override
    public List<Reserva> findByEstado(String estado) {
        return reservaRepository.findByEstado(estado);
    }

    @Override
    public List<Reserva> findAll() {
        return (List<Reserva>) reservaRepository.findAll();
    }

}
