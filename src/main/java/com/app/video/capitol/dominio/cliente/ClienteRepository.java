/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.cliente;

import com.app.video.capitol.dominio.reserva.Reserva;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    /**
     *
     * @param nombre
     * @return
     */
    List<Cliente> findByNombre(String nombre);

    /**
     *
     * @param estado
     * @return
     */
    List<Cliente> findByEstado(String estado);

    /**
     *
     * @param rut
     * @return
     */
    Cliente findByRut(String rut);

    /**
     *
     * @param email
     * @return
     */
    Cliente findByEmail(String email);

}
