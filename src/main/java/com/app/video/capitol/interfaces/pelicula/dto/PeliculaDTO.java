/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.pelicula.dto;

/**
 *
 * @author DESARROLLO
 */
public class PeliculaDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private String nombreDirector;
    private Integer cantidad;
    private String estado;
    private String catalogos;
    private String actores;

    public PeliculaDTO() {
    }

    public PeliculaDTO(Long id, String titulo, String descripcion, String nombreDirector, Integer cantidad, String estado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombreDirector = nombreDirector;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public PeliculaDTO(Long id, String titulo, String descripcion, String nombreDirector, Integer cantidad, String estado, String catalogos, String actores) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombreDirector = nombreDirector;
        this.cantidad = cantidad;
        this.estado = estado;
        this.catalogos = catalogos;
        this.actores = actores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCatalogos() {
        return catalogos;
    }

    public void setCatalogos(String catalogos) {
        this.catalogos = catalogos;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

}
