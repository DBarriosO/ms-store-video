/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.accesoCliente.facade.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.app.video.capitol.interfaces.accesoCliente.facade.AccesoClienteFacade;
import com.app.video.capitol.interfaces.accesoCliente.service.AccesoClienteService;
import com.app.video.capitol.utils.ObjectMapperUtil;

/**
 *
 * @author DESARROLLO
 */
@Component("AccesoClienteFacade")
@Transactional
public class AccesoClienteFacadeImpl implements AccesoClienteFacade {

    @Autowired
    AccesoClienteService accesoClienteService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

}
