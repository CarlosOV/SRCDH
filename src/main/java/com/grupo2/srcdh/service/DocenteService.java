/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.service;

import com.grupo2.srcdh.dao.Impl.DocenteDAOImpl;
import com.grupo2.srcdh.model.Docente;

/**
 *
 * @author carlos
 */
public class DocenteService {
    
    private final DocenteDAOImpl docenteDAO = new DocenteDAOImpl();
    
    public Docente getDocente(long id){
        return docenteDAO.Buscar(id);
    }
}
