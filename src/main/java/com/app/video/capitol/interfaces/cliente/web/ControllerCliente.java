/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.cliente.web;

import com.app.video.capitol.interfaces.cliente.dto.ClienteDTO;
import com.app.video.capitol.interfaces.cliente.facade.ClienteFacade;
import com.app.video.capitol.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/Cliente")
@Api(value = "Cliente RestController", description = "This API has a CRUD for Cliente")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerCliente {

    @Autowired
    ClienteFacade clienteFacade;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save Cliente", notes = "Return ResponseUtil")
    public ResponseUtil saveCliente(@RequestBody @Valid ClienteDTO personDTO) {
        return clienteFacade.save(personDTO);
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "findById/{id}", notes = "Return a ClienteDTO By id")
    public ClienteDTO findById(@PathVariable("id") Long id) {
        return clienteFacade.findById(id);
    }

}
