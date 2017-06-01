/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.accesoCliente;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface AccesoClienteRepository extends CrudRepository<AccesoCliente, Long> {

    AccesoCliente findByToken(String token);
    
    AccesoCliente findByIdCliente(Long idCliente);

    List<AccesoCliente> findByStateLogin(String stateLogin);

    @Query(value = "SELECT * \n"
            + "FROM acceso_cliente \n"
            + "WHERE id = ?1 \n"
            + "AND id_cliente = ?2   \n"
            + "AND token = ?3 \n"
            + "AND state_login =  ?4 \n"
            + "AND state_token = ?5", nativeQuery = true)
    AccesoCliente findLogout(Long idUserAccess, Long idCliente, String token, String stateLogin, String stateToken);

}
