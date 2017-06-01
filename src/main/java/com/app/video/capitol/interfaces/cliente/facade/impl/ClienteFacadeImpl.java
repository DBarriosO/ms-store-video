/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.cliente.facade.impl;

import com.app.video.capitol.dominio.cliente.Cliente;
import com.app.video.capitol.interfaces.cliente.dto.ClienteDTO;
import com.app.video.capitol.interfaces.cliente.facade.ClienteFacade;
import com.app.video.capitol.interfaces.cliente.service.ClienteService;
import com.app.video.capitol.utils.ConstanteUtil;
import com.app.video.capitol.utils.ObjectMapperUtil;
import com.app.video.capitol.utils.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionSystemException;

/**
 *
 * @author DESARROLLO
 */
@Component("ClienteFacade")
//@Transactional
public class ClienteFacadeImpl implements ClienteFacade {

    @Autowired
    ClienteService clienteService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public ResponseUtil save(ClienteDTO clienteDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            clienteDTO.setContrasenhia(com.app.video.capitol.utils.Encrytacion.getMd5(clienteDTO.getContrasenhia()));
            Cliente cliente = objectMapper.convertValue(clienteDTO, Cliente.class);
            clienteService.save(cliente);
            clienteDTO = objectMapper.convertValue(cliente, ClienteDTO.class);
            clienteDTO.setContrasenhia(null);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setObject(clienteDTO);
            return responseUtil;
        } catch (IllegalArgumentException | NoSuchAlgorithmException p) {
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, p);
        } catch (DataIntegrityViolationException da) {
            responseUtil.setMessage(da.getRootCause().getMessage());
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            return responseUtil;
        }
        responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
        responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
        return responseUtil;
    }

    @Override
    public ClienteDTO findById(Long id) {
        ClienteDTO clienteDTO = objectMapper.convertValue(clienteService.findById(id), ClienteDTO.class);
        return clienteDTO;
    }

}
