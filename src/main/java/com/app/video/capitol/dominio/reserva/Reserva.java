/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.reserva;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "reserva")
@ApiModel("Model Reserva")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "id_cliente", required = true)
    private Long idCliente;
    @ApiModelProperty(value = "id_pelicula", required = true)
    private Long idPelicula;
    @ApiModelProperty(value = "fecha_reserva", required = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar fechaReserva;
    @ApiModelProperty(value = "fecha_entrega", required = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar fechaEntrega;
    @ApiModelProperty(value = "estado", required = true)
    private String estado;

    public Reserva() {
    }

    public Reserva(Long id, Long idCliente, Long idPelicula, Calendar fechaReserva, Calendar fechaEntrega, String estado) {
        this.id = id;
        this.idCliente = idCliente;
        this.idPelicula = idPelicula;
        this.fechaReserva = fechaReserva;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    public Long id() {
        return id;
    }

    public Long idCliente() {
        return idCliente;
    }

    public Long idPelicula() {
        return idPelicula;
    }

    public Calendar fechaReserva() {
        return fechaReserva;
    }

    public String estado() {
        return estado;
    }

    public Calendar fechaEntrega() {
        return fechaEntrega;
    }

}
