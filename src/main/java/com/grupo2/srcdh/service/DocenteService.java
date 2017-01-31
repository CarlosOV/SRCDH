/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.service;

import com.grupo2.srcdh.dao.Impl.DocenteDAOImpl;
import com.grupo2.srcdh.exception.UnableToSaveException;
import com.grupo2.srcdh.model.Docente;
import static spark.Spark.halt;

/**
 *
 * @author carlos
 */
public class DocenteService {
    
    private final DocenteDAOImpl docenteDAO = new DocenteDAOImpl();
    
    public Docente getDocente(long id){
        return docenteDAO.Buscar(id);
    }
    
    public Docente updateDocente(long id, String nombre, String apellido, String dni){

        Docente docente = docenteDAO.Buscar(id);
        docente.setNombre(nombre);
        docente.setApellido(apellido);
        docente.setDni(dni);
        try {
            docenteDAO.Actualizar(docente);

        } catch (UnableToSaveException ex) {
            halt(400, "{\"status\":\"400\",\"message\":\"Bad Request\"}");
        }
        return docente; 
    }
}
