/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.dao;

import com.grupo2.srcdh.generic.GenericDAO;
import com.grupo2.srcdh.model.Docente;

/**
 *
 * @author carlos
 */
public interface IDocenteDAO extends GenericDAO<Docente, Long>  {
    public void update(Docente docente);
}
