/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.reserva.facade.impl;

import com.app.video.capitol.dominio.accesoCliente.AccesoCliente;
import com.app.video.capitol.dominio.pelicula.Pelicula;
import com.app.video.capitol.dominio.reserva.Reserva;
import com.app.video.capitol.interfaces.accesoCliente.service.AccesoClienteService;
import com.app.video.capitol.interfaces.cliente.service.ClienteService;
import com.app.video.capitol.interfaces.pelicula.service.PeliculaService;
import com.app.video.capitol.interfaces.reserva.dto.ReservaInDTO;
import com.app.video.capitol.interfaces.reserva.dto.ReservaOutDTO;
import com.app.video.capitol.interfaces.reserva.facade.ReservaFacade;
import com.app.video.capitol.interfaces.reserva.service.ReservaService;
import com.app.video.capitol.utils.ConstanteUtil;
import com.app.video.capitol.utils.ObjectMapperUtil;
import com.app.video.capitol.utils.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("ReservaFacade")
@Service
public class ReservaFacadeImpl implements ReservaFacade {

    @Autowired
    ReservaService reservaService;

    @Autowired
    AccesoClienteService accesoClienteService;

    @Autowired
    PeliculaService peliculaService;

    @Autowired
    ClienteService clienteService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public ResponseUtil save(ReservaInDTO reservaInDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            AccesoCliente accesoCliente = new AccesoCliente();
            accesoCliente = accesoClienteService.findByToken(reservaInDTO.getToken());
            if (accesoCliente != null) {
                if (accesoCliente.stateToken().equals(ConstanteUtil.STATE_EXPIRED)) {
                    responseUtil.setMessage("Cliente No Autorizado.");
                    responseUtil.setTipo(ConstanteUtil.CODE_UNAUTHORIZED);
                    return responseUtil;
                }
            } else {
                responseUtil.setMessage("Cliente No Logueado.");
                responseUtil.setTipo(ConstanteUtil.CODE_BAD_REQUEST);
                return responseUtil;
            }

            Reserva reserva = new Reserva();
            reserva = reservaService.findByIdPeliculaAndIdClienteAndEstado(reservaInDTO.getIdPelicula(), reservaInDTO.getIdCliente(), ConstanteUtil.STATE_RESERVADO);
            if (reserva != null) {
                responseUtil.setMessage("Usted tiene una reserva para esta pelicula la cual no ha sido entregada.");
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
                return responseUtil;
            }

            Pelicula pelicula = new Pelicula();
            pelicula = peliculaService.findById(reservaInDTO.getIdPelicula());
            if (pelicula == null) {
                responseUtil.setMessage("Pelicula no esta registrada.");
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
                return responseUtil;
            }
            if (pelicula.cantidad() <= 0) {
                responseUtil.setMessage("No es posible reserva esta pelicula, ya que se encuentra en estado NO DISPONIBLE.");
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
                return responseUtil;
            }

            Reserva reservaSave = new Reserva(null, reservaInDTO.getIdCliente(), reservaInDTO.getIdPelicula(), new GregorianCalendar(), null, ConstanteUtil.STATE_RESERVADO);

            reservaService.save(reservaSave);

            Integer cantidad = pelicula.cantidad() - 1;
            String estado = ConstanteUtil.STATE_DISPONIBLE;
            if (cantidad == 0) {
                estado = ConstanteUtil.STATE_NO_DISPONIBLE;
            }

            Pelicula peliculaUpdate = new Pelicula(pelicula.id(), pelicula.titulo(), pelicula.descripcion(), pelicula.nombreDirector(), cantidad, estado);
            peliculaService.save(peliculaUpdate);

            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            return responseUtil;
        } catch (Exception ex) {
            responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
            responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
            return responseUtil;
        }
    }

    @Override
    public ReservaOutDTO findById(Long id) {
        return convert(reservaService.findById(id));
    }

    @Override
    public List<ReservaOutDTO> findByIdCliente(Long idCliente, String estado) {
        return convert(reservaService.findByIdCliente(idCliente, estado));
    }

    @Override
    public List<ReservaOutDTO> findByIdPelicula(Long idPelicula, String estado) {
        return convert(reservaService.findByIdPelicula(idPelicula, estado));
    }

    @Override
    public ReservaOutDTO findByIdPeliculaAndIdClienteAndEstado(Long idPelicula, Long idCliente, String estado) {
        return convert(reservaService.findByIdPeliculaAndIdClienteAndEstado(idPelicula, idCliente, estado));
    }

    @Override
    public List<ReservaOutDTO> findByEstado(String estado) {
        return convert(reservaService.findByEstado(estado));
    }

    @Override
    public List<ReservaOutDTO> findAll() {
        return convert(reservaService.findAll());
    }

    public List<ReservaOutDTO> convert(List<Reserva> reservas) {
        List<ReservaOutDTO> reservaOutDTOs = new ArrayList<>();
        reservas.stream().map((reserva) -> {
            ReservaOutDTO reservaOutDTO = new ReservaOutDTO();
            reservaOutDTO.setEstado(reserva.estado());
            reservaOutDTO.setFechaEntrega(reserva.fechaEntrega());
            reservaOutDTO.setFechaReserva(reserva.fechaReserva());
            reservaOutDTO.setId(reserva.id());
            reservaOutDTO.setIdCliente(reserva.idCliente());
            reservaOutDTO.setIdPelicula(reserva.idPelicula());
            reservaOutDTO.setNombreCliente(clienteService.findById(reserva.idCliente()).nombre());
            reservaOutDTO.setTitulo(peliculaService.findById(reserva.idPelicula()).titulo());
            return reservaOutDTO;
        }).forEachOrdered((reservaOutDTO) -> {
            reservaOutDTOs.add(reservaOutDTO);
        });
        return reservaOutDTOs;
    }

    public ReservaOutDTO convert(Reserva reserva) {
        ReservaOutDTO reservaOutDTO = new ReservaOutDTO();
        reservaOutDTO = objectMapper.convertValue(reserva, ReservaOutDTO.class);
        reservaOutDTO.setNombreCliente(clienteService.findById(reserva.idCliente()).nombre());
        reservaOutDTO.setTitulo(peliculaService.findById(reserva.idPelicula()).titulo());
        return reservaOutDTO;
    }

}
