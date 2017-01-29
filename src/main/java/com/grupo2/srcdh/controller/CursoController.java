/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.controller;

import com.grupo2.srcdh.dao.Impl.EscuelaAcademicaDAOImpl;
import com.grupo2.srcdh.model.Curso;
import com.grupo2.srcdh.model.EscuelaAcademica;
import com.grupo2.srcdh.service.CursoService;
import com.grupo2.srcdh.service.EscuelaService;
import static com.grupo2.srcdh.util.JsonUtil.json;
import java.util.List;
import static spark.Spark.get;
import static spark.Spark.halt;

/**
 *
 * @author carlos
 */
public class CursoController {

    public CursoController(final CursoService cursoService, final EscuelaService escuelService) {
        get("/api/cursos", (req, res) -> {
            System.out.println("/api/cursos");
            return cursoService.getAllCurso();
        }, json());
        
        get("/api/cursos/:id", (req, res) -> {
            long id = 0;
            try{
                id = Long.parseLong(req.params(":id"));
            }catch(NumberFormatException e){
                System.out.println("NumberFormatException: " + e.getMessage());
                halt(400, "{\"status\":\"400\",\"message\":\"Bad request\"}");
            }
            
            return cursoService.getCurso(id);
        }, json());
        
        get("/api/escuelas", (req, res) -> {
            EscuelaAcademicaDAOImpl escuelaDAO = new EscuelaAcademicaDAOImpl();
            List<EscuelaAcademica> escuelas = escuelService.getAll();
            System.out.println("escuelas: "+escuelas);
            String salida = "{\"status\":\"200\", \"data\":[";
            List<Curso> cursos = null;
            EscuelaAcademica escuelaAux = null;
            
            for (EscuelaAcademica escuela : escuelas) {
                if(!escuelas.get(0).equals(escuela))salida+=",";
                escuelaAux =  escuelaDAO.Buscar(escuela.getId());
                        
                System.out.println("for");
                cursos = escuelaAux.getCurso();
                System.out.println("cursos: "+cursos);
                salida += "{"
                        + "\"id\":\""+ escuela.getId() +"\""
                        + ",\"nombre\":\""+ escuela.getNombre() +"\"" 
                        + ",\"cursos\":[";
                        
                for (Curso curso : cursos) {
                    if(!cursos.get(0).equals(curso))salida+=",";
                    
                    salida +="{"
                    + "\"id\":\""+ curso.getId() +"\""
                    + ",\"nombre\":\""+ curso.getNombre() +"\""
                    +"}";
                }
                        
                salida += "]}";
            }
            
            salida += "]}";
            System.out.println("salida: "+salida);
            halt(200, salida);
            return null;
        });
    }
    
}
