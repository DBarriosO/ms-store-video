/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.catalogoPelicula.web;

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
import com.app.video.capitol.interfaces.catalogoPelicula.dto.CatalogoPeliculaInfoDTO;
import com.app.video.capitol.interfaces.catalogoPelicula.facade.CatalogoPeliculaFacade;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
@RestController
@RequestMapping("/CatalogoPelicula")
@Api(value = "CatalogoPelicula RestController", description = "This API has a CRUD for CatalogoPelicula")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerCatalogoPelicula {

    @Autowired
    CatalogoPeliculaFacade catalogoPeliculaFacade;

    @RequestMapping(value = "findByIdCatalogo/{idCatalogo}", method = RequestMethod.GET)
    @ApiOperation(value = "findByIdCatalogo/{idCatalogo}", notes = "Return a CatalogoPeliculaInfoDTO By idCatalogo")
    public List<CatalogoPeliculaInfoDTO> findByIdCatalogo(@PathVariable("idCatalogo") Long idCatalogo) {
        return catalogoPeliculaFacade.findByIdCatalogo(idCatalogo);
    }

    @RequestMapping(value = "findByIdPelicula/{idPelicula}", method = RequestMethod.GET)
    @ApiOperation(value = "findByIdPelicula/{idPelicula}", notes = "Return a CatalogoPeliculaInfoDTO By idPelicula")
    public List<CatalogoPeliculaInfoDTO> findByIdPelicula(@PathVariable("idPelicula") Long idPelicula) {
        return catalogoPeliculaFacade.findByIdCatalogo(idPelicula);
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "findById/{id}", notes = "Return a CatalogoPeliculaInfoDTO By id")
    public CatalogoPeliculaInfoDTO findById(@PathVariable("id") Long id) {
        return catalogoPeliculaFacade.findById(id);
    }

}
