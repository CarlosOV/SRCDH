/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh;

import com.grupo2.srcdh.controller.CursoController;
import com.grupo2.srcdh.controller.InterceptorController;

import com.grupo2.srcdh.controller.UsuarioController;
import com.grupo2.srcdh.dao.Impl.CursoDAOImpl;
import com.grupo2.srcdh.exception.UnableToSaveException;
import com.grupo2.srcdh.model.Curso;
import com.grupo2.srcdh.service.CursoService;
import com.grupo2.srcdh.service.UsuarioService;

/**
 *
 * @author carlos
 */
public class App {
    public static void main(String[] args) throws UnableToSaveException{
        
        CursoDAOImpl cursoDAO = new CursoDAOImpl();
        cursoDAO.Guardar(new Curso("Curso A"));
        cursoDAO.Guardar(new Curso("Curso B"));
        cursoDAO.Guardar(new Curso("Curso C"));
        
        new InterceptorController();
        new UsuarioController(new UsuarioService());
        new CursoController(new CursoService());
    }
}
