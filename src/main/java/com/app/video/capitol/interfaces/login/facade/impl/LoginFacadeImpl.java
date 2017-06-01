/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.login.facade.impl;

import com.app.video.capitol.dominio.accesoCliente.AccesoCliente;
import com.app.video.capitol.dominio.cliente.Cliente;
import com.app.video.capitol.interfaces.accesoCliente.service.AccesoClienteService;
import com.app.video.capitol.interfaces.cliente.service.ClienteService;
import com.app.video.capitol.interfaces.login.dto.CredencialDTO;
import com.app.video.capitol.interfaces.login.dto.LoginDTO;
import com.app.video.capitol.interfaces.login.dto.LogoutDTO;
import com.app.video.capitol.interfaces.login.facade.LoginFacade;
import com.app.video.capitol.utils.ConstanteUtil;
import com.app.video.capitol.utils.ObjectMapperUtil;
import com.app.video.capitol.utils.ResponseUtil;
import com.app.video.capitol.utils.config.AuthUtils;
import com.app.video.capitol.utils.config.PasswordService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.GregorianCalendar;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO 13
 */
@Service
public class LoginFacadeImpl implements LoginFacade {

    public final static Logger LOG = LoggerFactory.getLogger(LoginFacadeImpl.class);

    @Context
    HttpHeaders headers;

    @Autowired
    private AccesoClienteService accesoClienteService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AuthUtils authUtils;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public ResponseUtil login(CredencialDTO credencialDTO, HttpServletRequest request) {
        ResponseUtil responseUtil = new ResponseUtil();
        AccesoCliente accesoCliente = new AccesoCliente();
        Cliente cliente = new Cliente();
        Cliente c = new Cliente();
        if (StringUtils.isEmpty(credencialDTO.getContrasenhia()) || StringUtils.isEmpty(credencialDTO.getEmail())) {
            responseUtil.setMessage(ConstanteUtil.MSG_ERROR_AUTENTICACION);
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            return responseUtil;
        }
        c = clienteService.findByEmail(credencialDTO.getEmail());
        if (c == null) {
            responseUtil.setMessage(ConstanteUtil.MSG_USER_NO_EXISTE);
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            return responseUtil;
        }
        cliente = clienteService.findById(c.id());

        if (cliente != null && cliente.estado().equals(ConstanteUtil.STATE_ACTIVO)) {
            boolean passok = PasswordService.equalsPassword(credencialDTO.getContrasenhia(), cliente.contrasenhia());
            if (passok) {
                LoginDTO loginDTO = new LoginDTO();

                loginDTO = objectMapper.convertValue(cliente, LoginDTO.class);

                String tokenStr = authUtils.createLoginToken(request.getRemoteHost(), cliente);
                accesoCliente = new AccesoCliente(null,
                        cliente.id(),
                        ConstanteUtil.STATE_LOGIN,
                        tokenStr,
                        ConstanteUtil.STATE_INITIATED,
                        new GregorianCalendar(),
                        null);
                accesoClienteService.save(accesoCliente);
                loginDTO.setIdAcessoCliente(accesoCliente.id());
                responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
                responseUtil.setTipo(ConstanteUtil.CODE_OK);
                responseUtil.setToken(tokenStr);
                responseUtil.setObject(loginDTO);
//                try {
//                    responseUtil.setObjectResponse(objectMapper.readTree(objectMapper.writeValueAsString(loginDTO)));
//                } catch (JsonProcessingException ex) {
//                    LOG.warn("Error : " + ex);
//                } catch (IOException ex) {
//                    LOG.error("Error : " + ex);
//                }
                return responseUtil;
            } else {
                responseUtil.setMessage(ConstanteUtil.MSG_PASS_NO_VALIDAD);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            }
        } else {
            if (cliente == null) {
                responseUtil.setMessage(ConstanteUtil.MSG_USER_NO_EXISTE);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            } else {
                responseUtil.setMessage(ConstanteUtil.MSG_NO_ACCESS);
                responseUtil.setTipo(ConstanteUtil.CODE_UNAUTHORIZED);
            }
        }

        return responseUtil;
    }

    @Override
    public ResponseUtil logout(LogoutDTO logoutDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            AccesoCliente accesoCliente = new AccesoCliente();
            accesoCliente = accesoClienteService.findLogout(logoutDTO, ConstanteUtil.STATE_LOGIN, ConstanteUtil.STATE_INITIATED);
            if (accesoCliente == null) {
                responseUtil.setMessage(ConstanteUtil.MSG_USER_NO_LOGIN);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
                return responseUtil;
            }
            accesoCliente = new AccesoCliente(accesoCliente.id(),
                    accesoCliente.idCliente(),
                    ConstanteUtil.STATE_LOGOUT,
                    accesoCliente.token(),
                    ConstanteUtil.STATE_EXPIRED,
                    accesoCliente.loginDate(),
                    new GregorianCalendar());
            accesoClienteService.save(accesoCliente);
            responseUtil.setMessage(ConstanteUtil.MSG_USER_LOGOUT);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            return responseUtil;
        } catch (Exception e) {
            responseUtil.setMessage(ConstanteUtil.MSG_USER_ERROR_LOGOUT);
            responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
            return responseUtil;
        }
    }

}
