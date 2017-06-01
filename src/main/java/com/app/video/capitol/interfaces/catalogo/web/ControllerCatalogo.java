/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.catalogo.web;

import com.app.video.capitol.interfaces.catalogo.dto.CatalogoDTO;
import com.app.video.capitol.interfaces.catalogo.facade.CatalogoFacade;
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
@RequestMapping("/Catalogo")
@Api(value = "Catalogo RestController", description = "This API has a CRUD for Catalogo")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerCatalogo {

    @Autowired
    CatalogoFacade catalogoFacade;

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "findById/{id}", notes = "Return a CatalogoDTO By id")
    public CatalogoDTO findById(@PathVariable("id") Long id) {
        return catalogoFacade.findById(id);
    }

    @RequestMapping(value = "findByEstado/{estado}", method = RequestMethod.GET)
    @ApiOperation(value = "findByEstado/{estado}", notes = "Return a CatalogoDTO By estado")
    public List<CatalogoDTO> findByEstado(@PathVariable("estado") String estado) {
        return catalogoFacade.findByEstado(estado);
    }

}
