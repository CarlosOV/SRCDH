/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.service;

import com.grupo2.srcdh.dao.Impl.CursoDAOImpl;
import com.grupo2.srcdh.model.Curso;
import java.util.List;



/**
 *
 * @author carlos
 */
public class CursoService {
    private final CursoDAOImpl cursoDAO = new CursoDAOImpl();
    
    public List<Curso> getAllCurso(){
        System.out.println("Inicio");
        System.out.println("cursos"+cursoDAO.Listar());
        System.out.println("Fin");
        return cursoDAO.Listar();
    }
    
    public Curso getCurso(long id){
        return cursoDAO.Buscar(id);
    }
    
    public Curso createCurso(){
        return null;
    }
    
    public Curso updateCurso(long id, String username, String password){
        return null;
    }

}
