/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.reserva.dto;

/**
 *
 * @author DESARROLLO
 */
public class ReservaInDTO {

    private Long idPelicula;
    private Long idCliente;
    private Integer cantidad;
    private String token;

    public ReservaInDTO() {
    }

    public ReservaInDTO(Long idPelicula, Long idCliente, Integer cantidad, String token) {
        this.idPelicula = idPelicula;
        this.idCliente = idCliente;
        this.cantidad = cantidad;
        this.token = token;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
