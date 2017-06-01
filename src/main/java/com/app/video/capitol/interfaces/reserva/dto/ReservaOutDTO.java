/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.reserva.dto;

import java.util.Calendar;

/**
 *
 * @author DESARROLLO
 */
public class ReservaOutDTO {

    private Long id;
    private Long idCliente;
    private String nombreCliente;
    private Long idPelicula;
    private String titulo;
    private Calendar fechaReserva;
    private Calendar fechaEntrega;
    private String estado;

    public ReservaOutDTO() {
    }

    public ReservaOutDTO(Long id, Long idCliente, Long idPelicula, Calendar fechaReserva, Calendar fechaEntrega, String estado) {
        this.id = id;
        this.idCliente = idCliente;
        this.idPelicula = idPelicula;
        this.fechaReserva = fechaReserva;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    public ReservaOutDTO(Long id, Long idCliente, String nombreCliente, Long idPelicula, String titulo, Calendar fechaReserva, Calendar fechaEntrega, String estado) {
        this.id = id;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.fechaReserva = fechaReserva;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Calendar getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Calendar fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Calendar getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Calendar fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
