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
@Table(name="curso_abierto")
public class CursoAbierto implements Serializable {
    @Id @GeneratedValue
    @Column(name="idCursoAbierto")
    private long id;
    
    @ManyToOne
    @JoinColumn(name="idCicloAcademico")
    private CicloAcademico cicloAcademico;
    
    @ManyToOne
    @JoinColumn(name="idCurso")
    private Curso curso;
    
    @ManyToOne
    @JoinColumn(name="idEscuelaAcademica")
    private EscuelaAcademica escuelaAcademica;
  
    @ManyToOne
    @JoinColumn(name="idHorario")
    private Horario horario;
    
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    public CursoAbierto() {
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }
}
