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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author carlos
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    @Id @GeneratedValue
    @Column(name="idUsuario")
    private long id;
    
    @Column(name="email")
    private String email;
    
    @Column(name="contrasenha")
    private String contrasenha;
    
    @OneToMany(mappedBy = "usuario")
    private List<Token> tokens;
    
    @OneToOne(mappedBy = "usuario")
    private Docente docente;
    
    public Usuario(String email, String contrasenha) {
        this.email = email;
        this.contrasenha = contrasenha;
    }

    public Usuario() {
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
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
