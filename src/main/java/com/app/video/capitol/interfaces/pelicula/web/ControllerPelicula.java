/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.pelicula.web;

import com.app.video.capitol.interfaces.pelicula.dto.PeliculaDTO;
import com.app.video.capitol.interfaces.pelicula.facade.PeliculaFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
@RestController
@RequestMapping("/Pelicula")
@Api(value = "Pelicula RestController", description = "This API has a CRUD for Pelicula")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerPelicula {

    @Autowired
    PeliculaFacade peliculaFacade;

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "findById/{id}", notes = "Return a PeliculaDTO By id")
    public PeliculaDTO findById(@PathVariable("id") Long idPelicula) {
        return peliculaFacade.findById(idPelicula);
    }

    @RequestMapping(value = "findByEstado/{estado}", method = RequestMethod.GET)
    @ApiOperation(value = "findByEstado/{estado}", notes = "Return a PeliculaDTO By estado")
    public List<PeliculaDTO> findByEstado(@PathVariable("estado") String estado) {
        return peliculaFacade.findByEstado(estado);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "findAll", notes = "Return all PeliculaDTO")
    public List<PeliculaDTO> findAll() {
        return peliculaFacade.findAll();
    }

}
