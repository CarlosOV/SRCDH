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
@Table(name="curso")
public class Curso implements Serializable {
    @Id @GeneratedValue
    @Column(name="idCurso")
    private long id;
    
    @Column(name="nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "curso")
    private Set<DCaCurso> dCaCurso;
    
    @ManyToOne
    @JoinColumn(name="idEscuelaAcademica")
    private EscuelaAcademica escuelaAcademica;

    public Set<DCaCurso> getdCaCurso() {
        return dCaCurso;
    }

    public void setdCaCurso(Set<DCaCurso> dCaCurso) {
        this.dCaCurso = dCaCurso;
    }

    public EscuelaAcademica getEscuelaAcademica() {
        return escuelaAcademica;
    }

    public void setEscuelaAcademica(EscuelaAcademica escuelaAcademica) {
        this.escuelaAcademica = escuelaAcademica;
    }
    
    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public Curso() {
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
