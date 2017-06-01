/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.login.dto;

/**
 *
 * @author DESARROLLO
 */
public class LogoutDTO {

    private Long idAccesoCliente;
    private Long idCliente;
    private String token;

    public LogoutDTO() {
    }

    public LogoutDTO(Long idAccesoCliente, Long idCliente, String token) {
        this.idAccesoCliente = idAccesoCliente;
        this.idCliente = idCliente;
        this.token = token;
    }

    public Long getIdAccesoCliente() {
        return idAccesoCliente;
    }

    public void setIdAccesoCliente(Long idAccesoCliente) {
        this.idAccesoCliente = idAccesoCliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
