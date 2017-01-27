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
@Table(name="docente_ciclo_academico_curso")
public class DCaCurso implements Serializable {
    
    @Id @GeneratedValue
    @Column(name="idDCaCurso")
    private long id;

    public DCaCurso() {
    }
    
    @ManyToOne
    @JoinColumn(name="idCurso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name="idDocenteCicloAcademico")
    private DocenteCicloAcademico docenteCicloAcademico;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public DocenteCicloAcademico getDocenteCicloAcademico() {
        return docenteCicloAcademico;
    }

    public void setDocenteCicloAcademico(DocenteCicloAcademico docenteCicloAcademico) {
        this.docenteCicloAcademico = docenteCicloAcademico;
    }
    
}
