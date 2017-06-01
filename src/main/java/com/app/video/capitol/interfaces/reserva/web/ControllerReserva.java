/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.reserva.web;

import com.app.video.capitol.interfaces.reserva.dto.ReservaInDTO;
import com.app.video.capitol.interfaces.reserva.dto.ReservaOutDTO;
import com.app.video.capitol.interfaces.reserva.facade.ReservaFacade;
import com.app.video.capitol.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DESARROLLO
 */
@RestController
@RequestMapping("/Reserva")
@Api(value = "Reserva RestController", description = "This API has a CRUD for Reserva")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerReserva {

    @Autowired
    ReservaFacade reservaFacade;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save Reserva", notes = "Return ResponseUtil")
    public ResponseUtil saveReserva(@RequestBody @Valid ReservaInDTO reservaInDTO) {
        return reservaFacade.save(reservaInDTO);
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "findById/{id}", notes = "Return a ReservaOutDTO By id")
    public ReservaOutDTO findById(@PathVariable("id") Long id) {
        return reservaFacade.findById(id);
    }

    @RequestMapping(value = "findByIdCliente/{idCliente}/{estado}", method = RequestMethod.GET)
    @ApiOperation(value = "findByIdCliente/{idCliente}/{estado}", notes = "Return a ReservaOutDTO By idCliente and estado")
    public List<ReservaOutDTO> findByIdCliente(@PathVariable("idCliente") Long idCliente, @PathVariable("estado") String estado) {
        return reservaFacade.findByIdCliente(idCliente, estado);
    }

    @RequestMapping(value = "findByIdPelicula/{idPelicula}/{estado}", method = RequestMethod.GET)
    @ApiOperation(value = "findByIdPelicula/{idPelicula}/{estado}", notes = "Return a ReservaOutDTO By idPelicula and estado")
    public List<ReservaOutDTO> findByIdPelicula(@PathVariable("idPelicula") Long idPelicula, @PathVariable("estado") String estado) {
        return reservaFacade.findByIdPelicula(idPelicula, estado);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "findAll", notes = "Return all ReservaOutDTO")
    public List<ReservaOutDTO> findAll() {
        return reservaFacade.findAll();
    }

    @RequestMapping(value = "findByIdPeliculaAndIdClienteAndEstado/{idPelicula}/{idCliente}/{estado}", method = RequestMethod.GET)
    @ApiOperation(value = "findByIdPeliculaAndIdClienteAndEstado/{idPelicula}/{idCliente}/{estado}", notes = "Return a ReservaOutDTO By idPelicula and idCliente and estado")
    public ReservaOutDTO findByIdPeliculaAndIdClienteAndEstado(@PathVariable("idPelicula") Long idPelicula, @PathVariable("idCliente") Long idCliente, @PathVariable("estado") String estado) {
        return reservaFacade.findByIdPeliculaAndIdClienteAndEstado(idPelicula, idCliente, estado);
    }

    @RequestMapping(value = "findByEstado/{estado}", method = RequestMethod.GET)
    @ApiOperation(value = "findByEstado/{estado}", notes = "Return a ReservaOutDTO By  estado")
    public List<ReservaOutDTO> findByEstado(@PathVariable("estado") String estado) {
        return reservaFacade.findByEstado(estado);
    }
}
