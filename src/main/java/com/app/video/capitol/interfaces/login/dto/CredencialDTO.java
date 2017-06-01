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
public class CredencialDTO {

    private String email;
    private String contrasenhia;

    public CredencialDTO() {
    }

    public CredencialDTO(String email, String contrasenhia) {
        this.email = email;
        this.contrasenhia = contrasenhia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenhia() {
        return contrasenhia;
    }

    public void setContrasenhia(String contrasenhia) {
        this.contrasenhia = contrasenhia;
    }

}
