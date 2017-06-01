/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.videoTienda;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface VideoTiendaRepository extends CrudRepository<VideoTienda, Long> {

    /**
     *
     * @param nombre
     * @return
     */
    List<VideoTienda> findByNombre(String nombre);

}
