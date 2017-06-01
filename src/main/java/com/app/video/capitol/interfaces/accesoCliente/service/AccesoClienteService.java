/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.accesoCliente.service;

import com.app.video.capitol.dominio.accesoCliente.AccesoCliente;
import com.app.video.capitol.interfaces.login.dto.LogoutDTO;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface AccesoClienteService {

    AccesoCliente save(AccesoCliente accesoCliente);

    AccesoCliente findById(Long id);

    AccesoCliente findByIdCliente(Long idCliente);

    AccesoCliente findByToken(String token);

    List<AccesoCliente> findByStateLogin(String stateLogin);

    AccesoCliente findLogout(LogoutDTO logoutDTO, String stateLogin, String stateToken);

}
