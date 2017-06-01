/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.catalogo.facade.impl;

import com.app.video.capitol.dominio.catalogo.Catalogo;
import com.app.video.capitol.interfaces.catalogo.dto.CatalogoDTO;
import com.app.video.capitol.interfaces.catalogo.facade.CatalogoFacade;
import com.app.video.capitol.interfaces.catalogo.service.CatalogoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.app.video.capitol.utils.ObjectMapperUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
@Component("CatalogoFacade")
@Transactional
public class CatalogoFacadeImpl implements CatalogoFacade {

    @Autowired
    CatalogoService catalogoService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public List<CatalogoDTO> findByEstado(String estado) {
        return convert(catalogoService.findByEstado(estado));
    }

    @Override
    public CatalogoDTO findById(Long id) {
        return objectMapper.convertValue(catalogoService.findById(id), CatalogoDTO.class);
    }

    public List<CatalogoDTO> convert(List<Catalogo> catalogos) {
        List<CatalogoDTO> catalogoDTOs = new ArrayList<>();
        catalogos.stream().map((catalogo) -> new CatalogoDTO(catalogo.id(), catalogo.nombre(), catalogo.estado())).forEachOrdered((catalogoDTO) -> {
            catalogoDTOs.add(catalogoDTO);
        });
        return catalogoDTOs;
    }

}
