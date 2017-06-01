/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.cliente.service;

import com.app.video.capitol.dominio.cliente.Cliente;

/**
 *
 * @author DESARROLLO
 */
public interface ClienteService {

    Cliente save(Cliente cliente);

    Cliente findById(Long id);

    Cliente findByEmail(String email);
}
