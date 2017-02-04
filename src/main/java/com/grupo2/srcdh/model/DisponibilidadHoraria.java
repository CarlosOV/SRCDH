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
@Table(name="disponibilidad_horaria")
public class DisponibilidadHoraria implements Serializable {

    @Id @GeneratedValue
    @Column(name="idDisponibilidadHoraria")
    private long id;
    
    @Column(name="dia")
    private String dia;
    
    @Column(name="hora")
    private String hora;

    @ManyToOne
    @JoinColumn(name="idDocente")
    private Docente docente;

    public DisponibilidadHoraria(String dia, String hora) {
        this.dia = dia;
        this.hora = hora;
    }

    public DisponibilidadHoraria(String dia, String hora, Docente docente) {
        this.dia = dia;
        this.hora = hora;
        this.docente = docente;
    }

    public DisponibilidadHoraria() {
    }
    
    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
