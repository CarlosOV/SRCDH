/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.service;

import com.grupo2.srcdh.dao.Impl.EscuelaAcademicaDAOImpl;
import com.grupo2.srcdh.model.EscuelaAcademica;
import java.util.List;

/**
 *
 * @author carlos
 */
public class EscuelaService {
    
    public EscuelaAcademicaDAOImpl escuelaDAO = new EscuelaAcademicaDAOImpl();
    
    public List<EscuelaAcademica> getAll(){
        return escuelaDAO.Listar();
    }
    
}
