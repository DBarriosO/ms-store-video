/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.catalogo.service;

import com.app.video.capitol.dominio.catalogo.Catalogo;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface CatalogoService {

    List<Catalogo> findByEstado(String estado);

    Catalogo findById(Long id);

}
