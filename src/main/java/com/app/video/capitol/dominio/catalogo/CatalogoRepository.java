/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.catalogo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface CatalogoRepository extends CrudRepository<Catalogo, Long> {

    /**
     *
     * @param nombre
     * @return
     */
    Catalogo findByNombre(String nombre);

    /**
     *
     * @param estado
     * @return
     */
    List<Catalogo> findByEstado(String estado);
}
