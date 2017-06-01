/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.accesoCliente.service.impl;

import com.app.video.capitol.dominio.accesoCliente.AccesoCliente;
import com.app.video.capitol.dominio.accesoCliente.AccesoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.app.video.capitol.interfaces.accesoCliente.service.AccesoClienteService;
import com.app.video.capitol.interfaces.login.dto.LogoutDTO;

/**
 *
 * @author DESARROLLO
 */
@Component("AccesoClienteService")
@Service
public class AccesoClienteServiceImpl implements AccesoClienteService {

    @Autowired
    AccesoClienteRepository accesoClienteRepository;

    @Override
    public AccesoCliente save(AccesoCliente accesoCliente) {
        return accesoClienteRepository.save(accesoCliente);
    }

    @Override
    public AccesoCliente findById(Long id) {
        return accesoClienteRepository.findOne(id);
    }

    @Override
    public AccesoCliente findByIdCliente(Long idCliente) {
        return accesoClienteRepository.findByIdCliente(idCliente);
    }

    @Override
    public AccesoCliente findByToken(String token) {
        return accesoClienteRepository.findByToken(token);
    }

    @Override
    public List<AccesoCliente> findByStateLogin(String stateLogin) {
        return (List<AccesoCliente>) accesoClienteRepository.findByStateLogin(stateLogin);
    }

    @Override
    public AccesoCliente findLogout(LogoutDTO logoutDTO, String stateLogin, String stateToken) {
        return accesoClienteRepository.findLogout(logoutDTO.getIdAccesoCliente(), logoutDTO.getIdCliente(), logoutDTO.getToken(), stateLogin, stateToken);
    }

}
