/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.catalogoPelicula.dto;

/**
 *
 * @author DESARROLLO
 */
public class CatalogoPeliculaInfoDTO {

    private Long id;
    private Long idCatalogo;
    private Long idPelicula;
    private String titulo;
    private String descripcion;
    private String nombreDirector;
    private Integer cantidad;
    private String estado;
    private String nombre;
    private String estadoCatalogo;
    private String actores;

    public CatalogoPeliculaInfoDTO() {
    }

    public CatalogoPeliculaInfoDTO(Long id, Long idCatalogo, Long idPelicula, String titulo, String descripcion, String nombreDirector, Integer cantidad, String estado) {
        this.id = id;
        this.idCatalogo = idCatalogo;
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombreDirector = nombreDirector;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public CatalogoPeliculaInfoDTO(Long id, Long idCatalogo, Long idPelicula, String titulo, String descripcion, String nombreDirector, Integer cantidad, String estado, String nombre, String estadoCatalogo) {
        this.id = id;
        this.idCatalogo = idCatalogo;
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombreDirector = nombreDirector;
        this.cantidad = cantidad;
        this.estado = estado;
        this.nombre = nombre;
        this.estadoCatalogo = estadoCatalogo;
    }

    public CatalogoPeliculaInfoDTO(Long id, Long idCatalogo, Long idPelicula, String titulo, String descripcion, String nombreDirector, Integer cantidad, String estado, String nombre, String estadoCatalogo, String actores) {
        this.id = id;
        this.idCatalogo = idCatalogo;
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombreDirector = nombreDirector;
        this.cantidad = cantidad;
        this.estado = estado;
        this.nombre = nombre;
        this.estadoCatalogo = estadoCatalogo;
        this.actores = actores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Long idCatalogo) {
        this.idCatalogo = idCatalogo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoCatalogo() {
        return estadoCatalogo;
    }

    public void setEstadoCatalogo(String estadoCatalogo) {
        this.estadoCatalogo = estadoCatalogo;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

}
