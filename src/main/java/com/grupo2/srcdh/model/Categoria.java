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
@Table(name="categoria")
public class Categoria implements Serializable {
    @Id @GeneratedValue
    @Column(name="idCategoria")
    private long id;
    
    @Column(name="nombre")
    private String nombre;

    @OneToMany(mappedBy = "categoria")
    private Set<Docente> docentes;

    public Categoria() {
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    
    public Set<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(Set<Docente> docentes) {
        this.docentes = docentes;
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
}
