/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.service;

import com.grupo2.srcdh.dao.Impl.DocenteDAOImpl;
import com.grupo2.srcdh.model.DisponibilidadHoraria;
import com.grupo2.srcdh.model.Docente;
import com.grupo2.srcdh.model.Usuario;
import java.util.List;

/**
 *
 * @author carlos
 */
public class HorasService {
    
    public DocenteDAOImpl docenteDAO = new DocenteDAOImpl();
    
    public List<DisponibilidadHoraria> getHoras(Usuario user){
        
        Docente docenteaux = null;
        Docente docente = user.getDocente();
        docenteaux = docenteDAO.Buscar(docente.getId());

        return docenteaux.getDisponibilidadHorarias();
    }
    public List<DisponibilidadHoraria> setHoras(Docente docente){
        return null;
    }
}
