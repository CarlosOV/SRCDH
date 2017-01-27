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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author carlos
 */
@Entity
@Table(name="docente")
public class Docente implements Serializable {

    @OneToOne
    @JoinColumn(name = "frn_usuario_id")
    private Usuario usuario;

    @Id @GeneratedValue
    @Column(name="idDocente")
    private long id;
    
    @Column(name="nombre")
    private String nombre;
    
        
    @Column(name="apellido")
    private String apellido;
    
    @Column(name="dni")
    private String dni;

    @ManyToOne
    @JoinColumn(name="idCatgoria")
    private Categoria categoria;
    
    @OneToMany(mappedBy = "docente")
    private Set<DocenteCicloAcademico> docenteCicloAcademico;

    public Docente() {
    }

    public Docente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<DocenteCicloAcademico> getDocenteCicloAcademico() {
        return docenteCicloAcademico;
    }

    public void setDocenteCicloAcademico(Set<DocenteCicloAcademico> docenteCicloAcademico) {
        this.docenteCicloAcademico = docenteCicloAcademico;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

}
