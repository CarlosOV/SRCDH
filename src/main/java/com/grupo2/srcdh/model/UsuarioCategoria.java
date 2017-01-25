/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author carlos
 */

@Entity
@Table(name="usuario_categoria")
public class UsuarioCategoria implements Serializable {
    @Id @GeneratedValue
    @Column(name="idUsuarioCategoria")
    private long id;
    
    @Column(name="nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "usuarioCategoria")
    private Set<Usuario> usuarios;

    public UsuarioCategoria(String nombre) {
        this.nombre = nombre;
    }

    public UsuarioCategoria() {
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
