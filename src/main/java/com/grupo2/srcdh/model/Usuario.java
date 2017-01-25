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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author carlos
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    @Id @GeneratedValue
    @Column(name="id")
    private long id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellido")
    private String apellido;
    
    @Column(name="dni")
    private String dni;
    
    @Column(name="email")
    private String email;
    
    @Column(name="contrasenha")
    private String contrasenha;

    @OneToMany(mappedBy = "usuario")
    private Set<CursoAbierto> cursosAbiertos;
    
    @OneToMany(mappedBy = "usuario")
    private Set<Token> tokens;
    
    @OneToMany(mappedBy = "usuario")
    private Set<DisponibilidadHoraria> disponibilidadHoraria;
    
    @ManyToOne
    @JoinColumn(name="idUsuarioCategoria")
    private UsuarioCategoria usuarioCategoria;
    
    public Usuario(String nombre, String apellido, String dni, String email, String contrasenha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.contrasenha = contrasenha;
    }

    public Usuario() {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

}
