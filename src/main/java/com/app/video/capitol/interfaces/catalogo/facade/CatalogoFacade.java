/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.catalogo.facade;

import com.app.video.capitol.interfaces.catalogo.dto.CatalogoDTO;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface CatalogoFacade {

    List<CatalogoDTO> findByEstado(String estado);

    CatalogoDTO findById(Long id);
}
