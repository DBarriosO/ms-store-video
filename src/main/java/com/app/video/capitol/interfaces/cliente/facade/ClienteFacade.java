/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.cliente.facade;

import com.app.video.capitol.interfaces.cliente.dto.ClienteDTO;
import com.app.video.capitol.utils.ResponseUtil;

/**
 *
 * @author DESARROLLO
 */
public interface ClienteFacade {

    ResponseUtil save(ClienteDTO clienteDTO);

    ClienteDTO findById(Long id);
}
