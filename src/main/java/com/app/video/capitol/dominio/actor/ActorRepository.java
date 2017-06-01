/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.actor;

import com.app.video.capitol.dominio.catalogo.*;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface ActorRepository extends CrudRepository<Actor, Long> {

    /**
     *
     * @param nombre
     * @return
     */
    Actor findByNombre(String nombre);

    /**
     *
     * @param estado
     * @return
     */
    List<Actor> findByEstado(String estado);
}
