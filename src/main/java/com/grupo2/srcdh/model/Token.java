/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author carlos
 */

@Entity
@Table(name="token")
public class Token implements Serializable {
    @Id @GeneratedValue
    @Column(name="idToken")
    private long id;
    
    @Column(name="token")
    private String token;
    
    @Column(name="activo")
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    public Token(String token, boolean activo) {
        this.token = token;
        this.activo = activo;
    }

    public Token() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
