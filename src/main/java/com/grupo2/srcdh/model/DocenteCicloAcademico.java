/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.model;

import java.io.Serializable;
import java.util.List;
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
@Table(name="docente_ciclo_academico")
public class DocenteCicloAcademico implements Serializable {
  
    @Id @GeneratedValue
    @Column(name="idDocenteCicloAcademico")
    private long id;
    
    @ManyToOne
    @JoinColumn(name="idCicloAcademico")
    private CicloAcademico cicloAcademico;
  
    @ManyToOne
    @JoinColumn(name="idDocente")
    private Docente docente;
    
    @OneToMany(mappedBy = "docenteCicloAcademico")
    private List<DCaCurso> dCaCurso;
    
    @OneToMany(mappedBy = "docenteCicloAcademico")
    private List<DisponibilidadHoraria> disponibilidadHoraria;

    public DocenteCicloAcademico() {
    }

    public DocenteCicloAcademico(CicloAcademico cicloAcademico, Docente docente) {
        this.cicloAcademico = cicloAcademico;
        this.docente = docente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<DCaCurso> getdCaCurso() {
        return dCaCurso;
    }

    public void setdCaCurso(List<DCaCurso> dCaCurso) {
        this.dCaCurso = dCaCurso;
    }

    public List<DisponibilidadHoraria> getDisponibilidadHoraria() {
        return disponibilidadHoraria;
    }

    public void setDisponibilidadHoraria(List<DisponibilidadHoraria> disponibilidadHoraria) {
        this.disponibilidadHoraria = disponibilidadHoraria;
    }
}
