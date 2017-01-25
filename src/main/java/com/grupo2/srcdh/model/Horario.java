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
@Table(name="horario")
public class Horario implements Serializable {
    @Id @GeneratedValue
    @Column(name="id")
    private long id;
            
    @Column(name="dia")
    private String dia;
    
    @Column(name="inicioHora")
    private String inicioHora;
    
    @Column(name="finHora")
    private String finHora;

    @OneToMany(mappedBy = "horario")
    private Set<CursoAbierto> cursosAbiertos;
    
    public Horario(String dia, String inicioHora, String finHora) {
        this.dia = dia;
        this.inicioHora = inicioHora;
        this.finHora = finHora;
    }

    public Horario() {
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getInicioHora() {
        return inicioHora;
    }

    public void setInicioHora(String inicioHora) {
        this.inicioHora = inicioHora;
    }

    public String getFinHora() {
        return finHora;
    }

    public void setFinHora(String finHora) {
        this.finHora = finHora;
    }
   
}
