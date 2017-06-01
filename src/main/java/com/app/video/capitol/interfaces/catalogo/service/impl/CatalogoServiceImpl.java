/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.catalogo.service.impl;

import com.app.video.capitol.dominio.catalogo.Catalogo;
import com.app.video.capitol.dominio.catalogo.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.app.video.capitol.interfaces.catalogo.service.CatalogoService;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
@Component("CatalogoService")
@Service
public class CatalogoServiceImpl implements CatalogoService {

    @Autowired
    CatalogoRepository catalogoRepository;

    @Override
    public List<Catalogo> findByEstado(String estado) {
       return catalogoRepository.findByEstado(estado);
    }

    @Override
    public Catalogo findById(Long id) {
       return catalogoRepository.findOne(id);
    }

}
