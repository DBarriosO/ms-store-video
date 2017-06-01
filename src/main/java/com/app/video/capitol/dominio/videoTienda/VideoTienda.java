/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.dominio.videoTienda;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "video_tienda", uniqueConstraints
        = @UniqueConstraint(columnNames = "nit", name = "uk_nit")
)
@ApiModel("Model VideoTienda")
public class VideoTienda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "nombre", required = true)
    private String nombre;
    @ApiModelProperty(value = "nit", required = true)
    private String nit;
    @ApiModelProperty(value = "direccion", required = true)
    private String direccion;
    @ApiModelProperty(value = "email", required = true)
    private String email;
    @ApiModelProperty(value = "pagina_web", required = true)
    private String paginaWeb;
    @ApiModelProperty(value = "nombre_gerente", required = true)
    private String nombreGerente;

    public VideoTienda() {
    }

    public VideoTienda(Long id, String nombre, String nit, String direccion, String email, String paginaWeb, String nombreGerente) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.email = email;
        this.paginaWeb = paginaWeb;
        this.nombreGerente = nombreGerente;
    }

    public Long id() {
        return id;
    }

    public String nombre() {
        return nombre;
    }

    public String nit() {
        return nit;
    }

    public String direccion() {
        return direccion;
    }

    public String email() {
        return email;
    }

    public String paginaWeb() {
        return paginaWeb;
    }

    public String nombreGerente() {
        return nombreGerente;
    }

}
