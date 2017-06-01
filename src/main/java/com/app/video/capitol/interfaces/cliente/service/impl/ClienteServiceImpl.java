/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.cliente.service.impl;

import com.app.video.capitol.dominio.cliente.Cliente;
import com.app.video.capitol.dominio.cliente.ClienteRepository;
import com.app.video.capitol.interfaces.cliente.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("ClienteService")
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Cliente save(Cliente user) {
        return clienteRepository.save(user);
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findOne(id);
    }

    @Override
    public Cliente findByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
}
